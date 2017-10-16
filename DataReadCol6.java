import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class DataReadCol6 {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = null;

		try {
			String json = "{\"id\":" + CustomerConstant.id + ",\"lid\":" + CustomerConstant.lid + ",\"association\":"
					+ CustomerConstant.association + ",\"classificationNodes\":[";

			InputStream inp = new FileInputStream("D:/eclipse-mars-workspace/XLReader/input/country.xlsx");
			int ctr = 0;
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);

			Iterator rowIter = (sheet).iterator();
			int rownum = 1;

			Set countries = new HashSet<Map>();
			Map<String, List<Account>> countryMap = new HashMap<String, List<Account>>();
			
			
			while (rowIter.hasNext()) {
				Account ac = new Account();
				Row myRow = (Row) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				if (rownum > 1) {
					Vector<String> cellStoreVector = new Vector<String>();

					// --------------------------
					String country = null;
					String account = null;
					String currency = null;

					List<Account> sortedAccounts = null;

					// --------------------------
					int columnIdex = 0;
					while (cellIter.hasNext()) {

						Cell myCell = (Cell) cellIter.next();
						System.out.print(myCell.toString());
						System.out.print(" ");
						String cellvalue = myCell.toString();
						
						if (columnIdex == 0) {

							country = cellvalue;
							sortedAccounts = countryMap.get(country);
							if (sortedAccounts == null) {
								sortedAccounts = new ArrayList<Account>();
							}

						} else if (columnIdex == 1) {
							account = cellvalue;
							ac.setAccountType(account);

						} else if (columnIdex == 2) {
							currency = cellvalue;
							ac.setCurrency(currency);
							sortedAccounts.add(ac);
							countryMap.put(country, sortedAccounts);
						}

						cellStoreVector.addElement(cellvalue);
						columnIdex++;
					}

					String firstcolumnValue = null;
					String secondcolumnValue = null;

					int i = 0;
					firstcolumnValue = cellStoreVector.get(i).toString();
					secondcolumnValue = cellStoreVector.get(i + 1).toString();

					insertQuery(firstcolumnValue, secondcolumnValue);
				}
				rownum++;
			}

			// iterate country from countryMap object

			Set<String> countryKeys = countryMap.keySet();
			System.out.println("-----------------------------------");
			for (String country : countryKeys) {
				// System.out.println(country);

				List<Account> sortedAccounts  = countryMap.get(country);
				Collections.sort(sortedAccounts);
				System.out.println();
				for (Account ac : sortedAccounts) {
					System.out.println(country+"  "+ ac.getAccountType()+"  "+ac.getCurrency());
					
				}

			}

			// Set<String> accountTypeSet = accountMap.keySet();
			// for (String accountType : accountTypeSet) {
			// json = json + "{\"id\":" + "\"" + CountryConstant.id +
			// accountType + "\",\"lid\":\""
			// + CountryConstant.lid + accountType + "\",\"home\":\"" +
			// CountryConstant.home + accountType
			// + "\",\"name\":\"" + accountType + "\",\"description\":\"" +
			// accountType
			// + "\",\"objectType\":{},\"status\":\"" + CountryConstant.id
			// +
			// "\",\"versionInfo\":\"1.0\",\"externalIdentifiers\":[],\"classification\":[],\"associations\":[";
			//
			// //
			// Set<Account> accountSet = accountMap.get(accountType);
			// for (Account ac : accountSet) {
			//
			// }
			// System.out.println();
			// System.out.println(json);
			// }
			// System.out.println(json);
			// json = removeLastChar(json, 1);
			// json = json + "]}";
			// System.out.println(json);
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (fis != null) {

				fis.close();

			}

		}

		// showExelData(sheetData);

	}

	private static void insertQuery(String firstcolumnvalue, String secondcolumnvalue) {

		System.out.println(firstcolumnvalue + " " + secondcolumnvalue);

	}

	private static String removeLastChar(String str, Integer numChar) {
		return str.substring(0, str.length() - numChar);
	}
}