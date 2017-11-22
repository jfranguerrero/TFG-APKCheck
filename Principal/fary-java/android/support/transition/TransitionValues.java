package android.support.transition;

import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TransitionValues
{
  public final Map<String, Object> values = new HashMap();
  public View view;
  
  public TransitionValues() {}
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof TransitionValues)) && (view == view) && (values.equals(values));
  }
  
  public int hashCode()
  {
    return view.hashCode() * 31 + values.hashCode();
  }
  
  public String toString()
  {
    String str1 = "TransitionValues@" + Integer.toHexString(hashCode()) + ":\n";
    str1 = str1 + "    view = " + view + "\n";
    str1 = str1 + "    values:";
    Iterator localIterator = values.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      str1 = str1 + "    " + str2 + ": " + values.get(str2) + "\n";
    }
    return str1;
  }
}
