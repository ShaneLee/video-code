# Podcasts script

The following scripts can be used to download podcasts from 
their RSS feeds. It has the following features: 

    * Downloads all podcasts from multiple RSS feeds
    * Stores each podcast in its own directory with all its episodes
    * Logs each download so multiple runs of the script don't redownload the
      same podcast. In addition this enables the user to delete
      unwanted/listened to podcasts and the script will know to not redownload
      them.
    * Renames the files so they have a consistent format

The following dependencies are required to run this script: 

* ffmpeg (really we only need ffprobe, but that's a package of ffmpeg)
* xmllint 


### Usage

1. Replace the RSS feeds in `podcasts.txt` with your favourite podcast's RSS
   urls in the format URL<space>name (note the name is optional)
2. Run `./download_all_podcasts.sh`


The following video was created of the making of this script:
https://youtu.be/30nEkSZXnHk
