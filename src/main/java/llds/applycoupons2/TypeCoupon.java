package llds.applycoupons2;

import java.util.List;

public class TypeCoupon {
    CategoryType type;
   static List<CategoryType> categoryTypeList;
    static  {
        categoryTypeList.add(CategoryType.ELECTRONIC);
    }

}
