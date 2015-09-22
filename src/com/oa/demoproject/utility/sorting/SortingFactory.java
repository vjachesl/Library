package com.oa.demoproject.utility.sorting;

/**
 * Created by viacheslav on 20.09.15.
 */
public class SortingFactory {
    String type;
    public String getType() {
        return type;
    }
    public SortingFactory(String type) {
        this.type=type;
    }
    public Sort createSortOrder()
    {
        Sort s=null;
        if(getType().equals("bookNameIncr"))
            s=new BookNameSortIncr();
        else if(getType().equals("bookNameDecr"))
            s=new BookNameSortDecr();
        else if(getType().equals("bookIsbnIncr"))
            s=new BookIsbnSortIncr();
        else if(getType().equals("bookIsbnDecr"))
            s=new BookIsbnSortDecr();
        else if(getType().equals("bookAuthorIncr"))
            s=new BookAuthorSortIncr();
        else if(getType().equals("bookAuthorDecr"))
            s=new BookAuthorSortDecr();
        return s;
    }

}
