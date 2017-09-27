package lomt.pearson.constant;

public class HEConstant {
	
	//domain values
	public static String A = "Anatomy & Physiology";
	public static String BUSINESS_STATISTICES = "Business Statistics";
	public static String C = "";
	public static String D = "";
	public static String E = "";
	
	//status values
	public static String APPROVED = "Approved";
	public static String AWAITING_APPROVAL = "Awaiting approval";
	public static String DELETED = "Deleted";
	public static String DRAFT = "Draft";
	public static String PARTIALLY_APPROVED = "Partially approved";
	public static String REJECTED = "Rejected";
	
	//Error Messages
	public static String LANGUAGE_BLANK = "Language value is blank in Row : 6";
	public static String QUESTION_BLANK = "Question should not be blank in row: 7";
	public static String ASSERTION8_VAL = "Assertion8 should not be blank in row: 7";
	public static String ASSERTION1_VAL = "Assertion1 should not be blank in row: 7";
	public static String ASSERTION2_VAL = "Assertion2 should not be blank in row: 7";
	public static String DATE_FORMAT = "Creation Date column should be in proper format in row: 8";
	public static String TOC_NUM_HEADER = "TOC Numbering column is mandatory in Row : 12";
	public static String NEW_EO_AND_NEW_LO_SAME_ROW =  "NEW Enabling Objective #NEW Enabling Objectives Both NEW Learning Objective # and NEW Enabling Objective # cannot have value in the same row. Row # is : 15";
	public static String PROFICIENCY_COL_VAL = "Proficiency Column value is mismatched from the available values in Row : 17";
	public static String DOMAIN_COL_VAL = "Domain Column value is mismatched from the available values in Row : 17";
	public static String BLOOMS_CONG_P_DIMENSIONS_TEXT = "Blooms Cognitive Process Dimensions Column value is mismatched from the available values in Row : 17";
	public static String BLOOMS_KNOWD_DIMENSIONS_TEXT = "Blooms Knowledge Dimensions Column value is mismatched from the available values in Row : 17";
	public static String CONCEPT_SUBJECT_MISCONCEPTION_Y =  "Given \"Concept Subject to Misconception\" is \"Y\", at least One Column value from Misconception Descriptive Statement 1 column to Misconception Assertion(s) 3 should have values in row: 18";
	public static String CONCEPT_SUB_MISCONCEPTION_N = "Given \"Concept Subject to Misconception\" is \"N\", the row values for \"Misconception Descriptive Statement 1\", \"Misconception Feedback 1\", \"Misconception Assertion(s) 1\", \"Misconception Descriptive Statement 2\", \"Misconception Feedback 2\", \"Misconception Assertion(s) 2\", \"Misconception Descriptive Statement 3\", \"Misconception Feedback 3\", and \"Misconception Assertion(s) 3\" should be blane in row 15";
	
}
