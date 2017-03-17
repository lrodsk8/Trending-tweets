package luisrodriguez.trendingtweets;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Luis Rodriguez on 3/13/2017.
 */
public class TwitterTokens {

    private static final String TAG = TwitterTokens.class.getSimpleName();
    private static final String CONSUMER_KEY = "AWrEMoZUzxsYxhAOsZlVEc41B";
    private static final String CONSUMER_SECRET = "IelayCcR4qfe7U03FAPnIh7SQpnw8fQDZkLVYnmlxQaQNp92Jy";


    /**
     * Encodes the consumer key and secret to create the basic authorization key used for Twitter BearerToken
     * @param consumerKey   The Application's consumer key
     * @param consumerSecret   The Applications Secret Key
     * @return The encoded consumer key and secret key separated by a colon.
     */
    private static String encodeKeys(String consumerKey, String consumerSecret) {
        String encodedConsumerKey = null;
        String encodedConsumerSecret = null;
        try {
            encodedConsumerKey =    URLEncoder.encode(consumerKey, "UTF-8");
            encodedConsumerSecret = URLEncoder.encode(consumerSecret, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;
        byte[] encodedBytes = Base64.encode(fullKey.getBytes(), Base64.NO_WRAP);
        return new String(encodedBytes);
    }

    /**
     * Helper method to get the encoded keys
     * @return The encoded consumer key and secret key separated by a colon.
     */
    public static String getEncodedKeys(){
        return encodeKeys(CONSUMER_KEY, CONSUMER_SECRET);
    }
}
