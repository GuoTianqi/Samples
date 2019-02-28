package com.gtq.javasample.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class OkHttpMain {
    public static void main(String[] args) {
        Request request = new Request.Builder()
                .url("https://vodkgeyttp9c.vod.126.net/cloudmusic/765c351f3ea005efa5a8a36b9e00743f.mp4?wsSecret=40d4eb1a1a759091ee47fb049114af39&wsTime=1551268914&ext=NnR5gMvHcZNcbCz592mDGeZFm4Ub04RX1MsQU9o2jl4NiLChw%2BTzEOCKMH2OA4dHitWpOcoMa5wdSQdakj41rhZZxbX321rbihYhTjfAuSzN%2B8Ulftv%2FAaIBgK10JFL3cq3jUEiOeeDBo0GRPs%2FZnAXeQCdQaZbA8HmcNWWkMBSkpZKumf1IhxDJoCou5DbbSeUUYcJHIRFbKKedu65XmzwRKV2fNuaW2KtffSjaPKnv76KSObHgr3FSFBIkxDhWHsUnkw6zKb9ad16A97RkQXoxOgKkXfmB%2FSRAcJos2irYXuahuDFrTaN6oHymY0BGbkTmBXu08OzARqdgpJ1%2F0YP5UK7GeFN%2FWAhda1cVv%2BRt2oRn%2B%2B4HEPnsJcGoxAt25xgmYlMq5ZK59FVFxofkz7lRacdf%2BkkabmLC6gTSPD8g0%2Bo0dilL%2BIqk5FAESy0XcN5FMN7qvmUJJcJZmzS6Oz0afXgZKIKeKG8HfVQDhVLiZE6LfAbb0worrwZaq8sf14lMCCVFKAEO90jatWiM3g%3D%3D")
                .build();
        try(Response response = new OkHttpClient().newCall(request).execute()) {
            try (FileOutputStream fos = new FileOutputStream("vod.mp4")) {
                InputStream is = response.body().byteStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                do {
                    len = is.read(buffer);
                    if (len == -1) {
                        return;
                    }

                    fos.write(buffer, 0, len);
                } while (true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
