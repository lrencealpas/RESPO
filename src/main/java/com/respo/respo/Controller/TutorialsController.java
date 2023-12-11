package com.respo.respo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.respo.respo.Entity.TutorialsEntity;
import com.respo.respo.Service.TutorialsService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/tutorial")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorialsController {

    @Autowired
    TutorialsService tserv;

    @Value("${video.upload.directory}") // Inject the directory path from application.properties
    private String uploadDirectory;

    @GetMapping("/print")
    public String itWorks() {
        return "It works";
    }

    // Create - Insert a tutorial with video content
    @PostMapping("/insertTutorial")
    public TutorialsEntity insertTutorial(@RequestParam("file") MultipartFile file,
                                         @RequestParam("title") String title,
                                         @RequestParam("description") String description) {
        try {
            TutorialsEntity tutorial = new TutorialsEntity();
            tutorial.setTitle(title);
            tutorial.setDesc(description);

            // Save video file in the specified directory
            byte[] bytes = file.getBytes();
            // Set the content to the bytes of the video file
            tutorial.setContent(bytes);

            return tserv.insertTutorial(tutorial);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Or handle the exception appropriately
        }
    }


    // Read - Get all tutorials
    @GetMapping("/getAllTutorials")
    public List<TutorialsEntity> getAllTutorials() {
        return tserv.getAllTutorials();
    }

    // Update - Update a tutorial record
    @PutMapping("/updateTutorial/{videoId}")
    public TutorialsEntity updateTutorial(@PathVariable int videoId,
                                          @RequestBody TutorialsEntity newTutorialDetails) {
        return tserv.updateTutorial(videoId, newTutorialDetails);
    }

    // Delete - Delete a tutorial record
    @DeleteMapping("/deleteTutorial/{videoId}")
    public String deleteTutorial(@PathVariable int videoId) {
        return tserv.deleteTutorial(videoId);
    }
}
