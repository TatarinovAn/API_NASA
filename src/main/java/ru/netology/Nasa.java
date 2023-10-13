package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nasa {

    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdurl;

    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;


    public Nasa(@JsonProperty("copyright") String copyright,
                @JsonProperty("date") String date,
                @JsonProperty("explanation") String explanation,
                @JsonProperty("hdurl") String hdurl,
                @JsonProperty("media_type") String mediaType,
                @JsonProperty("service_version") String serviceVersion,
                @JsonProperty("title") String title,
                @JsonProperty("url") String url) {

        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }


    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return mediaType;
    }

    public String getService_version() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Nasa{" + "copyright = " + copyright +
                ", date = " + date +
                ", explanation = " + explanation +
                ", hdurl = " + hdurl +
                ", media_type = " + mediaType +
                ", service_version = " + serviceVersion +
                ", title = " + title +
                ", url = " + url +
                '}';
    }


    //    "copyright": "Bill Peters",
//            "date": "2020-07-17",
//            "explanation": "After local midnight on July 14 comet NEOWISE was still above the horizon for Goldenrod, Alberta, Canada, just north of Calgary, planet Earth. In this snapshot it makes for an awesome night with dancing displays of the northern lights. The long-tailed comet and auroral displays are beautiful apparitions in the north these days. Both show the influence of spaceweather and the wind from the Sun. Skygazers have widely welcomed the visitor from the Oort cloud, though C/2020 F3 (NEOWISE) is in an orbit that is now taking it out of the inner Solar System.  Comet NEOWISE Images: July 16 | July 15 | July 14 | July 13 | July 12 | July 11 | July 10 & earlier",
//            "hdurl": "https://apod.nasa.gov/apod/image/2007/DSC1028_PetersNEOWISEAuroralSpike.jpg",
//            "media_type": "image",
//            "service_version": "v1",
//            "title": "NEOWISE of the North",
//            "url": "https://apod.nasa.gov/apod/image/2007/DSC1028_PetersNEOWISEAuroralSpike_800.jpg"
}
