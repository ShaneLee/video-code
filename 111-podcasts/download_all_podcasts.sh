#!/usr/bin/env bash

# This script is the entry point for the downloads.

function get_podcasts() {
  awk ' { print $1 }' podcasts.txt
}

function main() {
  echo "Downloading all Podcasts $(date)"
  cd ~/podcasts
  for podcast in $(get_podcasts); do
    ./download_podcast.sh $podcast
  done
  cd - 
}

main
