package com.google.android.gms.internal;

public enum zzag
{
  private final String name;
  
  static
  {
    zzdA = new zzag("PLATFORM", 24, "_p");
    zzdB = new zzag("RANDOM", 25, "_r");
    zzdC = new zzag("REFERRER", 26, "_f");
    zzdD = new zzag("RESOLUTION", 27, "_rs");
    zzdE = new zzag("RUNTIME_VERSION", 28, "_rv");
    zzdF = new zzag("SDK_VERSION", 29, "_sv");
    zzdG = new zzag("SIMPLE_MAP", 30, "_smm");
    zzdH = new zzag("TIME", 31, "_t");
    zzdI = new zzag("URL", 32, "_u");
    zzdJ = new zzag("ADWORDS_CLICK_REFERRER", 33, "_awcr");
    zzdK = new zzag("DEVICE_ID", 34, "_did");
    zzdL = new zzag("ENCODE", 35, "_enc");
    zzdM = new zzag("GTM_VERSION", 36, "_gtmv");
    zzdN = new zzag("HASH", 37, "_hsh");
    zzdO = new zzag("INSTALL_REFERRER", 38, "_ir");
    zzdP = new zzag("JOINER", 39, "_jn");
    zzdQ = new zzag("MOBILE_ADWORDS_UNIQUE_ID", 40, "_awid");
    zzdR = new zzag("REGEX_GROUP", 41, "_reg");
    zzdS = new zzag("DATA_LAYER_WRITE", 42, "_dlw");
    zzdT = new zzag("LOWERCASE_STRING", 43, "_ls");
    zzdU = new zzag("UPPERCASE_STRING", 44, "_us");
    zzdV = new zzag("EXPERIMENT_ENABLED", 45, "_ee");
    zzdW = new zzag("IN_EXPERIMENT", 46, "_ie");
    zzdX = new zzag("EXPERIMENT_VARIATION_INDEX", 47, "_evi");
    zzdY = new zzag("EXPERIMENT_UID", 48, "_euid");
    zzdZ = new zzag("AUDIENCE_LISTS", 49, "_aud");
    zzea = new zzag("CSS_SELECTOR", 50, "_sel");
    zzeb = new zzag("GA_CLIENT_ID", 51, "_gacid");
    zzec = new zzag("GEO_IP", 52, "_geo");
    zzed = new zzag("USER_AGENT", 53, "_uagt");
    zzee = new zzag("GA_FIRST_PAGE", 54, "_gafp");
    zzef = new zzag("EXPERIMENT_EXPIRATION_DATES", 55, "_xxd");
    zzeg = new zzag("UNDEFINED_VALUE", 56, "_uv");
    zzeh = new zzag("EXPERIMENT_STATE", 57, "_exs");
    zzei = new zzag("PRODUCT_SETTING_PROPERTY", 58, "_prodset");
    zzej = new zzag("GA_OPT_OUT_CLIENT", 59, "_gaoo_c");
    zzek = new zzag("GA_OPT_OUT_SERVER", 60, "_gaoo_s");
    zzel = new zzag("REGEX", 61, "_re");
    zzem = new zzag("STARTS_WITH", 62, "_sw");
    zzen = new zzag("ENDS_WITH", 63, "_ew");
    zzeo = new zzag("CONTAINS", 64, "_cn");
    zzep = new zzag("EQUALS", 65, "_eq");
    zzeq = new zzag("LESS_THAN", 66, "_lt");
    zzer = new zzag("LESS_EQUALS", 67, "_le");
    zzes = new zzag("GREATER_THAN", 68, "_gt");
    zzet = new zzag("GREATER_EQUALS", 69, "_ge");
    zzeu = new zzag("CSS_SELECTOR_PREDICATE", 70, "_css");
    zzev = new zzag("URL_MATCHES", 71, "_um");
    zzew = new zzag("ARBITRARY_PIXEL", 72, "_img");
    zzex = new zzag("ARBITRARY_HTML", 73, "_html");
    zzey = new zzag("GOOGLE_TAG_MANAGER", 74, "_gtm");
    zzez = new zzag("GOOGLE_ANALYTICS", 75, "_ga");
  }
  
  private zzag(String paramString)
  {
    name = paramString;
  }
  
  public String toString()
  {
    return name;
  }
}
