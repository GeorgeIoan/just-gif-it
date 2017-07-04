package george.stricat.io.justgifit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * Created by gstricat on 6/12/2017.
 */
@RestController public class UploadController {

    private final static Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${multipart.location}")
    private String location;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.IMAGE_GIF_VALUE)
    public String upload(@RequestPart("file") MultipartFile file,
                        @RequestParam("start") int start,
                        @RequestParam("end") int end,
                        @RequestParam("speed") int speed,
                        @RequestParam("repeat") boolean repeat){

        File videoFile = new File(location + "/" + System.currentTimeMillis() + ".mp4");

        try {
            file.transferTo(videoFile);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO
        }

        System.out.println("Small changes 12");

        LOG.info("Saved file to {}", videoFile.getAbsolutePath());
        return "";
    }
}
