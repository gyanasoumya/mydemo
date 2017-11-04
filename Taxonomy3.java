package taxonomy;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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

public class Taxonomy3 {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = null;

		try {
			// String json = "{\"id\":" + CustomerConstant.id + ",\"lid\":" +
			// CustomerConstant.lid + ",\"association\":"
			// + CustomerConstant.association + ",\"classificationNodes\":[";

			InputStream inp = new FileInputStream(
					"C:/Users/JAI JAGANNATHA/Desktop/country.xlsx");
			int ctr = 0;
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);

			Iterator rowIter = (sheet).iterator();
			int rownum = 1;

			Map<Country, Map<String, Set<CheckBook>>> countryMap = new HashMap<Country, Map<String, Set<CheckBook>>>();
			// Map<String, Set<CheckBook>> accountMap = null;
			while (rowIter.hasNext()) {
				Account ac = new Account();
				Row myRow = (Row) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				if (rownum > 1) {
					Vector<String> cellStoreVector = new Vector<String>();

					// --------------------------
					String account = null;
					String currency = null;

					Map<String, Set<CheckBook>> accountMap = null;
					Set<String> currencys = null;
					Set<CheckBook> checkBooks = null;

					// --------------------------
					int columnIdex = 0;
					CheckBook cb = new CheckBook();
					Country country = new Country();
					while (cellIter.hasNext()) {
						Cell myCell = (Cell) cellIter.next();
						String cellvalue = myCell.toString();

						if (columnIdex == 0) {
							country.setCountrylevel(cellvalue);
							
						} else if (columnIdex == 1) {
							account = cellvalue;
							
						} else if (columnIdex == 2) {
							currency = cellvalue;
							cb.setCurrency(currency);

						} else if (columnIdex == 3) {
							cb.setIsoCode(cellvalue);

						} else if (columnIdex == 4) {
							cb.setStdCheckBook(cellvalue);

						} else if (columnIdex == 5) {
							cb.setNoOfStdChkBook(cellvalue);

						} else if (columnIdex == 6) {
							cb.setCstmCheckBook(cellvalue);

						} else if (columnIdex == 7) {
							cb.setPaperStmt(cellvalue);

						} else if (columnIdex == 8) {
							cb.setNoOfPaperStmt(cellvalue);

						} else if (columnIdex == 9) {
							country.setHsbcentity(cellvalue);
							accountMap = countryMap.get(country);
							// System.out.println(accountMap);
							if (accountMap == null) {
								accountMap = new HashMap<String, Set<CheckBook>>();
							}
							System.out.println("Country  " + country);

							checkBooks = accountMap.get(account);
							if (checkBooks == null) {
								checkBooks = new HashSet<CheckBook>();
							}
							System.out.println("Account  " + account);
							System.out.println(checkBooks);
							System.out.println();

						} else if (columnIdex == 10) {
							cb.setRegion(cellvalue);
							checkBooks.add(cb);
							accountMap.put(account, checkBooks);
							// System.out.println(accountMap);
							countryMap.put(country, accountMap);
							System.out.println(countryMap);
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

			System.out.println("==================");
			System.out.println(countryMap);
			// iterate country from countryMap object

			Set<Country> countryKeys = countryMap.keySet();
			System.out
					.println("---------------------------------------------------------------------------");

			for (Country country : countryKeys) {
				// System.out.println(country);
				// System.out.println(cb.getHsbcEntity());
				Map<String, Set<CheckBook>> accountMap2 = countryMap
						.get(country);
				// Collections.sort(accountMap);
				System.out.println();
				Set<String> accounts = accountMap2.keySet();
				for (String account : accounts) {
					Set<CheckBook> checkBooks = accountMap2.get(account);
					for (CheckBook cb : checkBooks) {

						// System.out.println(country + "  " + account + "  " +
						// cb.getCurrency()+" "+cb.getIsoCode()+" "+cb.getStdCheckBook()+"  "+cb.getNoOfStdChkBook()+" "+cb.getCstmCheckBook()+" "+cb.getHsbcEntity()+" "+cb.getRegion());
						if (cb.getStdCheckBook().equalsIgnoreCase("y")
								&& cb.getCstmCheckBook().equalsIgnoreCase("y")) {
							// System.out.println(cb.getNoOfStdChkBook());
							String noOfChkBooks[] = cb.getNoOfStdChkBook()
									.split(",");
							for (String no : noOfChkBooks) {
								// System.out.print("\""+no+"\",");
								// System.out.println();
								System.out.println(country.getCountrylevel()
										+ "  " + country.getHsbcentity() + "  "
										+ account + "  " + cb.getCurrency()
										+ " " + cb.getIsoCode() + " "
										+ cb.getStdCheckBook() + "  " + no
										+ " " + cb.getCstmCheckBook() + " "
										+ cb.getPaperStmt() + " "
										+ cb.getNoOfPaperStmt() + " "
										+ cb.getRegion());
							}
						}
					}
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

	private static void insertQuery(String firstcolumnvalue,
			String secondcolumnvalue) {

		// System.out.println(firstcolumnvalue + " " + secondcolumnvalue);

	}

	private static String removeLastChar(String str, Integer numChar) {
		return str.substring(0, str.length() - numChar);
	}
}
