public class Main
{
    // ------------------- STATIC FINAL VARIABLES -------------------
    private static final String ASCII_ART_0 = "    .----.    .----.  ",
            ASCII_ART_1 = "   (  --  \\  /  --  )",
            ASCII_ART_2 = "          |  |        ",
            ASCII_ART_3 = "         _/  \\_      ",
            ASCII_ART_4 = "        (_    _)      ",
            ASCII_ART_5 = "     ,    `--`    ,   ",
            ASCII_ART_6 = "     \\'-.______.-'/  ",
            ASCII_ART_7 = "      \\          /   ",
            ASCII_ART_8 = "       '.--..--.'     ",
            ASCII_ART_9 = "         `\"\"\"\"\"` ",
            ASCII_CREDIT = "   ascii art by: jgs    ";

    private static final String TITLE_USA = "UNITED STATES OF AMERICA",
            TITLE_EAC = "EMPLOYMENT AUTHORIZATION CARD";
    private static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name",
            LABEL_USCIS_NUM = "USCIS#", LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#",
            LABEL_BIRTH_COUNTRY = "Country of Birth", LABEL_TERMS_CONDITIONS = "Terms and Conditions",
            LABEL_BIRTH_DATE = "Date of Birth", LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:",
            LABEL_EXPIRE_DATE = "Card Expires:", LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";

    // ------------------- MAIN METHOD -------------------
    public static void main(String[] args)
    {
        // ------------------- GET USER INPUT -------------------
        String surname = UtilityBelt.readString("Enter surname (2-45 chars): ", 2, 45);
        String givenName = UtilityBelt.readString("Enter given name (2-45 chars): ", 2, 45);
        String birthCountry = UtilityBelt.readString("Enter country of birth (2-45 chars): ", 2, 45);
        String category = UtilityBelt.readString("Enter category (1-5 chars): ", 1, 5);
        String cardNum = UtilityBelt.readString("Enter card number (5-20 chars): ", 5, 20);
        String termsAndConditions = UtilityBelt.readString("Enter terms and conditions (2-45 chars): ", 2, 45);
        char sex = UtilityBelt.readChar("Enter sex (M/F): ", "MFmf");

        // USCIS numbers
        int uscisNum1 = UtilityBelt.readInt("Enter first part of USCIS# (0-999): ", 0, 999);
        int uscisNum2 = UtilityBelt.readInt("Enter second part of USCIS# (0-999): ", 0, 999);
        int uscisNum3 = UtilityBelt.readInt("Enter third part of USCIS# (0-999): ", 0, 999);
        String uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);

        // Birthdate
        int birthDay = UtilityBelt.readInt("Enter birth day (1-31): ", 1, 31);
        String birthMonth = UtilityBelt.readString("Enter birth month (JAN-DEC): ", 3, 3).toUpperCase();
        int birthYear = UtilityBelt.readInt("Enter birth year (1900-2100): ", 1900, 2100);
        String dateOfBirth = formatDate(birthMonth, birthDay, birthYear);

        // Valid date
        int validMonth = UtilityBelt.readInt("Enter valid month (1-12): ", 1, 12);
        int validDay = UtilityBelt.readInt("Enter valid day (1-31): ", 1, 31);
        int validYear = UtilityBelt.readInt("Enter valid year (2000-2100): ", 2000, 2100);
        String validDate = formatDate(validMonth, validDay, validYear);

        // Expiration date
        int expireMonth = UtilityBelt.readInt("Enter expiration month (1-12): ", 1, 12);
        int expireDay = UtilityBelt.readInt("Enter expiration day (1-31): ", 1, 31);
        int expireYear = UtilityBelt.readInt("Enter expiration year (2000-2100): ", 2000, 2100);
        String expireDate = formatDate(expireMonth, expireDay, expireYear);

        // ------------------- PRINT CARD -------------------
        System.out.println(formatCard(surname, givenName, category, cardNum, birthCountry,
                termsAndConditions, sex, uscisNum, dateOfBirth, validDate, expireDate));
    }

    // ------------------- STATIC METHODS -------------------
    public static String formatDate(int month, int day, int year)
    {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public static String formatDate(String monthStr, int day, int year)
    {
        return String.format("%02d %s %04d", day, monthStr, year);
    }

    public static String formatCard(String surname, String givenName,
                                    String category, String cardNum, String birthCountry,
                                    String termsAndConditions, char sex, String uscisNum,
                                    String dateOfBirth, String validDate, String expireDate)
    {
        StringBuilder sb = new StringBuilder();

        sb.append("╔══════════════════════════════════════════════════════════════════════╗\n");
        sb.append(String.format("║%35s%35s║%n", TITLE_USA, ""));
        sb.append(String.format("║%60s%10s║%n", TITLE_EAC, ""));
        sb.append(String.format("║%-25s%-45s║%n", "", LABEL_SURNAME));
        sb.append(String.format("║%-25s%-45s║%n", "", surname));
        sb.append(String.format("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME));
        sb.append(String.format("║%-25s%-45s║%n", ASCII_ART_1, givenName));
        sb.append(String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM));
        sb.append(String.format("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum));
        sb.append(String.format("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY));
        sb.append(String.format("║%-25s%-45s║%n", ASCII_ART_5, birthCountry));
        sb.append(String.format("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS));
        sb.append(String.format("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions));
        sb.append(String.format("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX));
        sb.append(String.format("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex));
        sb.append(String.format("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate));
        sb.append(String.format("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate));
        sb.append(String.format("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER));
        sb.append("╚══════════════════════════════════════════════════════════════════════╝\n");

        return sb.toString();
    }
}