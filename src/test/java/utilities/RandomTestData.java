package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public   class RandomTestData {
    public static String GenerateRandomString(int count)
    {
        return  RandomStringUtils.randomAlphabetic(count);
    }
    public static String  GenerateRandomNumber(int count)
    {
        return (RandomStringUtils.randomNumeric(count));

    }
    public static   String GenerateRandomStringAndNumbers(int count)
    {
        return RandomStringUtils.randomAlphanumeric(count);
    }
}
