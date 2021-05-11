import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

public class CreateSnowflakeTable {

	public static String createChiFoodTable() {
		// parse json
		StringBuilder sb = new StringBuilder("CREATE TABLE CHICAGO.RESTAURANTS ( ");
		sb.append("inspection_id varchar(20),");
		sb.append("dba_name varchar(20),");
		sb.append("aka_name varchar(20),");
		sb.append("license_ varchar(20),");
		sb.append("facility_type varchar(20),");
		sb.append("address varchar(50),");
		sb.append("city varchar(50),");
		sb.append("state varchar(20),");
		sb.append("zip varchar(10)");
		sb.append(");");

		return sb.toString();
	}
	
	public static String createChiInsertStatement(String context) {
		JSONObject json = new JSONObject(context);
		System.out.println(json.toString());
		String insert = "INSERT INTO CHICAGO.RESTAURANTS (inspection_id,dba_name,aka_name,license_,facility_type,address,city,state,zip) VALUES {VALUES};";
		StringBuilder sb = new StringBuilder();
		sb.append("('"+json.getString("inspection_id")+"'),");
		sb.append("('"+json.getString("dba_name")+"'),");
		sb.append("('"+json.getString("aka_name")+"'),");
		sb.append("('"+json.getString("license_")+"'),");
		sb.append("('"+json.getString("facility_type")+"'),");
		sb.append("('"+json.getString("address")+"'),");
		sb.append("('"+json.getString("city")+"'),");
		sb.append("('"+json.getString("state")+"'),");
		sb.append("('"+json.getString("zip")+"')");		
		
		return insert.replace("{VALUES}", sb.toString());
	}

	@Test
	public void testCreateChiFoodTable() {
		String table = CreateSnowflakeTable.createChiFoodTable();
		System.out.println(table);
		assertEquals("Snowflake table", "CREATE TABLE CHICAGO.RESTAURANTS ( inspection_id varchar(20),dba_name varchar(20),aka_name varchar(20),license_ varchar(20),facility_type varchar(20),address varchar(50),city varchar(50),state varchar(20),zip varchar(10));", table);
	}
	@Test
	public void testCreateChiInsertStatement() {
		String context = "{\r\n" + 
				"   \"inspection_id\":\"2509319\",\r\n" + 
				"   \"dba_name\":\"HAI YEN\",\r\n" + 
				"   \"aka_name\":\"HAI YEN\",\r\n" + 
				"   \"license_\":\"10235\",\r\n" + 
				"   \"facility_type\":\"Restaurant\",\r\n" + 
				"   \"risk\":\"Risk 1 (High)\",\r\n" + 
				"   \"address\":\"1055 W ARGYLE ST \",\r\n" + 
				"   \"city\":\"CHICAGO\",\r\n" + 
				"   \"state\":\"IL\",\r\n" + 
				"   \"zip\":\"60640\",\r\n" + 
				"   \"inspection_date\":\"2021-05-07T00:00:00.000\",\r\n" + 
				"   \"inspection_type\":\"Canvass Re-Inspection\",\r\n" + 
				"   \"results\":\"Fail\",\r\n" + 
				"   \"violations\":\"3. MANAGEMENT, FOOD EMPLOYEE AND CONDITIONAL EMPLOYEE; KNOWLEDGE, RESPONSIBILITIES AND REPORTING - Comments: 2-102.14(O)\\tOBSERVED NO EMPLOYEE HEALTH POLICY/TRAINING ON SITE. INSTRUCTED FACILITY TO ESTABLISH AN APPROPRIATE EMPLOYEE HEALTH POLICY/TRAINING SYSTEM AND MAINTAIN WITH VERIFIABLE DOCUMENTS ON SITE.  PRIORITY FOUNDATION VIOLATION 7-38-010. NO CITATION ISSUED | 5. PROCEDURES FOR RESPONDING TO VOMITING AND DIARRHEAL EVENTS - Comments: 2-501.11 FOUND PROCEDURE/PLAN ON-SITE; HOWEVER, KIT NOT COMPLETE THE MISSING SOLUTION TO CONTROL NOROVIRUS FOR RESPONDING TO VOMITING AND DIARRHEAL EVENTS, ALSO MISSING MOP ETC. INSTRUCTED FACILITY TO MAINTAIN ANY APPROPRIATE SUPPLIES ON SITE. PRIORITY FOUNDATION VIOLATION 7-38-005. NO CITATION ISSUED | 25. CONSUMER ADVISORY PROVIDED FOR RAW/UNDERCOOKED FOOD - Comments:  FOUND NO REMINDER DISCLOSURE STATEMENTS INSIDE MENU FOR UNDERCOOKED FOOD BEING SOLD(BEEF FOR PHO) PRIORITY FOUNDATION VIOLATION#: 7-38-005. NO CITATION WAS ISSUED.  | 38. INSECTS, RODENTS, & ANIMALS NOT PRESENT - Comments: STILL OBSERVED EVIDENCE OF RODENT DROPPINGS ON THE SECOND FLOOR. ALSO, DEAD ROACHES ON EQUIPENTS, LIVE ROACHES ON TRAPS, DEAD ROACHES ON FLOORS.RUBBER GASKET WITH A LOT OF GRIMES AND STUCK ROACHES. CLEAN AND SANITIZE MENTIONED AREA PRIORITY FOUNDATION:7-38-020(A), NO CITATION ISSUED | 47. FOOD & NON-FOOD CONTACT SURFACES CLEANABLE, PROPERLY DESIGNED, CONSTRUCTED & USED - Comments: BROKEN RUBBER GASKET INSIDE THE TWO DOOR REACH-IN COOLERS AND WALK-IN COOLER ACROSS REPAIR/REPLACE, SURFACE MUST BE SMOOTH, CLEANABLE AND NON-ABSORBENT MATERIAL | 47. FOOD & NON-FOOD CONTACT SURFACES CLEANABLE, PROPERLY DESIGNED, CONSTRUCTED & USED - Comments: MUST NOT USE DUCT TAPE AS A MEANS OF REPAIR ON THE DOOR OF WALK-IN.SURFACE MUST BE SMOOTH AND CLEANABLE | 56. ADEQUATE VENTILATION & LIGHTING; DESIGNATED AREAS USED - Comments: PROTECTIVE LIGHT SHIELD WITH INSECT STUCK ON IT, CLEAN AND MAINTAINED. INSUFFICIENT LIGHTING INSIDE WALK-IN COOLER. MISSING LIGHT BULB REPLACE. | 60. PREVIOUS CORE VIOLATION CORRECTED - Comments: PREVIOUS CORE VIOLATION NOT CORRECTED FROM 6-12-2021, REPORT #2373712. #58) 2-102.13 FOUND SANITATION MANAGERS WITH NO ALLERGEN TRAINING. MUST PROVIDE PRIORITY FOUNDATION VIOLATION: 7-42-090, NO CITATION ISSUED\",\r\n" + 
				"   \"latitude\":\"41.97317176563255\",\r\n" + 
				"   \"longitude\":\"-87.65714083118823\",\r\n" + 
				"   \"location\":{\r\n" + 
				"      \"latitude\":\"-87.65714083118823\",\r\n" + 
				"      \"longitude\":\"41.97317176563255\"\r\n" + 
				"   }\r\n" + 
				"}\r\n";
		String statement = CreateSnowflakeTable.createChiInsertStatement(context);
		System.out.println(statement);
		assertEquals("Snowflake insert statement", "INSERT INTO CHICAGO.RESTAURANTS (inspection_id,dba_name,aka_name,license_,facility_type,address,city,state,zip) VALUES ('2509319'),('HAI YEN'),('HAI YEN'),('10235'),('Restaurant'),('1055 W ARGYLE ST '),('CHICAGO'),('IL'),('60640');", statement);
	}
}
