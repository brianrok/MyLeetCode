package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pagination {

	
	/*
	 * Complete the function below.
	 */

	    public static final String PAGE_DELIMITER = "";
	    static String[] paginate(int num, String[] results) throws RuntimeException{
	        if (num <= 0) {
	            throw new RuntimeException("Page size should be a positive integer.");
	        }
	        if (results == null) {
	            throw new RuntimeException("Search results should not be null.");
	        }
	        List<String> ret = new ArrayList<>();
	        List<String> currentPage = new ArrayList<>();
	        List<String> searchResults = Arrays.stream(results).collect(Collectors.toCollection(LinkedList::new));;
	        Set<String> hostsExisted = new HashSet<>();
	        
	        while(searchResults.size() > 0) {
	            Iterator<String> iter = searchResults.iterator();
	            while(iter.hasNext() && currentPage.size() < num) {
	                String row = iter.next();
	                String hostId = getHost(row);
	                if (!hostsExisted.contains(hostId)) {
	                    currentPage.add(row);
	                    iter.remove();
	                    hostsExisted.add(hostId);
	                }
	            }
	            iter = searchResults.iterator();
	            while (currentPage.size() < num && iter.hasNext()) {
	                currentPage.add(iter.next());
	                iter.remove();
	            }
	            ret.addAll(currentPage);
	            ret.add(PAGE_DELIMITER);
	            currentPage.clear();
	            hostsExisted.clear();
	        }
	        
	        if (ret.size() > 0 && PAGE_DELIMITER.equals(ret.get(ret.size() - 1))) {
	            ret.remove(ret.size() - 1);
	        }
	        
	        return ret.toArray(new String[ret.size()]);
	    }

	    static String getHost(String row) {
	        if (row == null) {
	            throw new RuntimeException("Search results contains null row");
	        }
	        String[] columns = row.split(",");
	        if (columns.length == 0 || columns[0].length() == 0) {
	            throw new RuntimeException("No host id found");
	        }
	        return columns[0];
	    }


	public static void main(String[] args) {
		String[] results = new String[] {
				"1,2",
				"3,4",
				"1,2",
				"3,3",
				"4,5",
				"2,4",
				"6,1",
				"11,8"
		};
		for (String row: paginate(3, results)) {
			System.out.println(row);
		}
	}

}
