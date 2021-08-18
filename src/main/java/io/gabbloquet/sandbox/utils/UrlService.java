package io.gabbloquet.sandbox.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final ConversionService conversion;

    public UrlService(UrlRepository urlRepository, ConversionService baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

    public String convertToShortUrl(String longUrl) {
        Url url = Url.builder()
            .longUrl(longUrl)
            .expiresDate(LocalDateTime.now().plusYears(2))
            .createdDate(LocalDateTime.now())
            .build();
        var entity = urlRepository.save(url);

        return conversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        var id = conversion.decode(shortUrl);
        var entity = urlRepository.findById(id);
        return entity.getLongUrl();
    }

    public static String extractUrl(String text)
    {
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        if(urlMatcher.find())
            return urlMatcher.group();
        else
            return null;
    }
}