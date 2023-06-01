#!/usr/bin/env bash

URL=$1

function format() {
  sed 's/ /-/g' $1 | tr '[:upper:]' '[:lower:]' | sed 's/://g' | sed "s/\'//g"
}

function podcast_title() {
  curl --silent $URL | \
  xmllint --format -xpath "//channel/title/text()" - | \
  format
}

function episodes() {
  curl --silent $URL | \
  xmllint --format -xpath "//item/enclosure/@url" - | \
  awk -F '\\.mp3' '{ print $1".mp3"}' | \
  awk -F '\\url="' '{ print $2 }' 
}

function have_previously_downloaded() {
  local directory=$1
  local episode=$2
  local log_file="$directory/$directory.txt"
  [ ! -f $log_file ] && touch $log_file && "New podcast, created log file"
  grep $(basename $episode) $log_file
}

function download_episodes() {
  local directory=$1
  while read -r episode; do 
    if [ -z $(have_previously_downloaded $directory $episode) ]; then
      echo "Downloading $episode"
      wget -q -O "$directory/$(basename $episode)" $episode
    else
      echo "Already got $(basename $episode) not downloading"
    fi
  done < <(episodes)
}

function log_downloaded() {
  local directory=$1
  cd $directory
  ls >> "$directory.txt"
  cd -
}

function get_file_format() {
  echo $1 | awk -F '\\.' '{ print $2 }'
}

# It's a lot less of a faff to get the title from the metadata
# than mess about with more XML parsing.
function get_title() {
  ffprobe -loglevel error -show_entries format_tags=title -of default=noprint_wrappers=1:nokey=1 $1 | \
  format
}

function rename_all() {
  local directory=$1
  cd $directory
  for file in $(ls | grep -v "txt"); do
    rename_file $file
  done 
  cd - 
}

function rename_file() {
  local file_to_rename=$1
  fmt=$(get_file_format $file_to_rename)
  local new_name=$(get_title $file_to_rename)
  mv $file_to_rename $new_name"."$fmt
}

function make_dir() {
  [ ! -d $1 ] && mkdir $1 || echo "Not making directory $1 - already exists"
}


function main() {
  [ -z $URL ] && echo "No RSS Feed provided. Exiting." && return
  local title=$(podcast_title)
  make_dir $title
  download_episodes $title
  log_downloaded $title
  rename_all $title
}

main
