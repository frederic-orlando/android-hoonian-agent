package com.example.hoonianAgent.presenter.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UtilsYoutube {
    private static final String DEFAULT = "/mqdefault.jpg";
    private static final String HD = "/maxresdefault.jpg";

    public static final String getThumbnailUrl(String youtubeUrl) {
        return getThumbnailUrl(youtubeUrl, false);
    }

    public static final String getThumbnailUrl(String youtubeUrl, boolean isHD) {
        String imageUrl = "";

        try {
            imageUrl = "http://img.youtube.com/vi/"+ extractYoutubeId(youtubeUrl);
            imageUrl += (isHD) ? HD : DEFAULT;
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return imageUrl;
    }

    private static String extractYoutubeId(String url) throws MalformedURLException {
        String query = new URL(url).getQuery();
        String[] param = query.split("&");
        String id = null;
        for (String row : param) {
            String[] param1 = row.split("=");
            if (param1[0].equals("v")) {
                id = param1[1];
            }
        }
        return id;
    }
}
