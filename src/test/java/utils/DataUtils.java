package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.SignupModel;
import java.io.File;
import java.io.IOException;

public class DataUtils {

    public static SignupModel getSignupData(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/test/resources/" + fileName), SignupModel.class);
    }
}