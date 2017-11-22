package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface zzbuy
{
  public static final class zza
    extends zzbun<zza>
    implements Cloneable
  {
    public String version;
    public int zzcss;
    public String zzcst;
    
    public zza()
    {
      zzadb();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label54:
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          } while (zzcss != zzcss);
          if (zzcst != null) {
            break;
          }
          bool1 = bool2;
        } while (zzcst != null);
        if (version != null) {
          break label124;
        }
        bool1 = bool2;
      } while (version != null);
      for (;;)
      {
        if ((zzcrX == null) || (zzcrX.isEmpty()))
        {
          if (zzcrX != null)
          {
            bool1 = bool2;
            if (!zzcrX.isEmpty()) {
              break;
            }
          }
          return true;
          if (zzcst.equals(zzcst)) {
            break label54;
          }
          return false;
          label124:
          if (!version.equals(version)) {
            return false;
          }
        }
      }
      return zzcrX.equals(zzcrX);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = zzcss;
      int i;
      int j;
      if (zzcst == null)
      {
        i = 0;
        if (version != null) {
          break label101;
        }
        j = 0;
        label39:
        k = m;
        if (zzcrX != null) {
          if (!zzcrX.isEmpty()) {
            break label112;
          }
        }
      }
      label101:
      label112:
      for (int k = m;; k = zzcrX.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = zzcst.hashCode();
        break;
        j = version.hashCode();
        break label39;
      }
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if (zzcss != 0) {
        paramZzbum.zzF(1, zzcss);
      }
      if ((zzcst != null) && (!zzcst.equals(""))) {
        paramZzbum.zzq(2, zzcst);
      }
      if ((version != null) && (!version.equals(""))) {
        paramZzbum.zzq(3, version);
      }
      super.zza(paramZzbum);
    }
    
    public zza zzaO(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (super.zza(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          zzcss = paramZzbul.zzacy();
          break;
        case 18: 
          zzcst = paramZzbul.readString();
          break;
        case 26: 
          version = paramZzbul.readString();
        }
      }
    }
    
    public zza zzadb()
    {
      zzcss = 0;
      zzcst = "";
      version = "";
      zzcrX = null;
      zzcsg = -1;
      return this;
    }
    
    public zza zzadc()
    {
      try
      {
        zza localZza = (zza)super.zzacN();
        return localZza;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    protected int zzv()
    {
      int j = super.zzv();
      int i = j;
      if (zzcss != 0) {
        i = j + zzbum.zzH(1, zzcss);
      }
      j = i;
      if (zzcst != null)
      {
        j = i;
        if (!zzcst.equals("")) {
          j = i + zzbum.zzr(2, zzcst);
        }
      }
      i = j;
      if (version != null)
      {
        i = j;
        if (!version.equals("")) {
          i = j + zzbum.zzr(3, version);
        }
      }
      return i;
    }
  }
  
  public static final class zzb
    extends zzbun<zzb>
    implements Cloneable
  {
    public byte[] zzcsu;
    public String zzcsv;
    public byte[][] zzcsw;
    public boolean zzcsx;
    
    public zzb()
    {
      zzadd();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          bool1 = bool2;
        } while (!Arrays.equals(zzcsu, zzcsu));
        if (zzcsv != null) {
          break;
        }
        bool1 = bool2;
      } while (zzcsv != null);
      while (zzcsv.equals(zzcsv))
      {
        bool1 = bool2;
        if (!zzbur.zza(zzcsw, zzcsw)) {
          break;
        }
        bool1 = bool2;
        if (zzcsx != zzcsx) {
          break;
        }
        if ((zzcrX != null) && (!zzcrX.isEmpty())) {
          break label140;
        }
        if (zzcrX != null)
        {
          bool1 = bool2;
          if (!zzcrX.isEmpty()) {
            break;
          }
        }
        return true;
      }
      return false;
      label140:
      return zzcrX.equals(zzcrX);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = Arrays.hashCode(zzcsu);
      int i;
      int i2;
      int j;
      if (zzcsv == null)
      {
        i = 0;
        i2 = zzbur.zzb(zzcsw);
        if (!zzcsx) {
          break label121;
        }
        j = 1231;
        label53:
        k = m;
        if (zzcrX != null) {
          if (!zzcrX.isEmpty()) {
            break label128;
          }
        }
      }
      label121:
      label128:
      for (int k = m;; k = zzcrX.hashCode())
      {
        return (j + ((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31) * 31 + k;
        i = zzcsv.hashCode();
        break;
        j = 1237;
        break label53;
      }
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if (!Arrays.equals(zzcsu, zzbuw.zzcsp)) {
        paramZzbum.zzb(1, zzcsu);
      }
      if ((zzcsw != null) && (zzcsw.length > 0))
      {
        int i = 0;
        while (i < zzcsw.length)
        {
          byte[] arrayOfByte = zzcsw[i];
          if (arrayOfByte != null) {
            paramZzbum.zzb(2, arrayOfByte);
          }
          i += 1;
        }
      }
      if (zzcsx) {
        paramZzbum.zzg(3, zzcsx);
      }
      if ((zzcsv != null) && (!zzcsv.equals(""))) {
        paramZzbum.zzq(4, zzcsv);
      }
      super.zza(paramZzbum);
    }
    
    public zzb zzaP(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (super.zza(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          zzcsu = paramZzbul.readBytes();
          break;
        case 18: 
          int j = zzbuw.zzc(paramZzbul, 18);
          if (zzcsw == null) {}
          byte[][] arrayOfByte;
          for (i = 0;; i = zzcsw.length)
          {
            arrayOfByte = new byte[j + i][];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzcsw, 0, arrayOfByte, 0, i);
              j = i;
            }
            while (j < arrayOfByte.length - 1)
            {
              arrayOfByte[j] = paramZzbul.readBytes();
              paramZzbul.zzacu();
              j += 1;
            }
          }
          arrayOfByte[j] = paramZzbul.readBytes();
          zzcsw = arrayOfByte;
          break;
        case 24: 
          zzcsx = paramZzbul.zzacA();
          break;
        case 34: 
          zzcsv = paramZzbul.readString();
        }
      }
    }
    
    public zzb zzadd()
    {
      zzcsu = zzbuw.zzcsp;
      zzcsv = "";
      zzcsw = zzbuw.zzcso;
      zzcsx = false;
      zzcrX = null;
      zzcsg = -1;
      return this;
    }
    
    public zzb zzade()
    {
      try
      {
        zzb localZzb = (zzb)super.zzacN();
        if ((zzcsw != null) && (zzcsw.length > 0)) {
          zzcsw = ((byte[][])zzcsw.clone());
        }
        return localZzb;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    protected int zzv()
    {
      int n = 0;
      int j = super.zzv();
      int i = j;
      if (!Arrays.equals(zzcsu, zzbuw.zzcsp)) {
        i = j + zzbum.zzc(1, zzcsu);
      }
      j = i;
      if (zzcsw != null)
      {
        j = i;
        if (zzcsw.length > 0)
        {
          int k = 0;
          int m = 0;
          j = n;
          while (j < zzcsw.length)
          {
            byte[] arrayOfByte = zzcsw[j];
            int i1 = k;
            n = m;
            if (arrayOfByte != null)
            {
              n = m + 1;
              i1 = k + zzbum.zzag(arrayOfByte);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      i = j;
      if (zzcsx) {
        i = j + zzbum.zzh(3, zzcsx);
      }
      j = i;
      if (zzcsv != null)
      {
        j = i;
        if (!zzcsv.equals("")) {
          j = i + zzbum.zzr(4, zzcsv);
        }
      }
      return j;
    }
  }
  
  public static final class zzc
    extends zzbun<zzc>
    implements Cloneable
  {
    public String tag;
    public boolean zzcbV;
    public long zzcsA;
    public int zzcsB;
    public zzbuy.zzd[] zzcsC;
    public byte[] zzcsD;
    public zzbuy.zza zzcsE;
    public byte[] zzcsF;
    public String zzcsG;
    public String zzcsH;
    public String zzcsI;
    public long zzcsJ;
    public zzbuy.zzb zzcsK;
    public byte[] zzcsL;
    public String zzcsM;
    public int zzcsN;
    public int[] zzcsO;
    public long zzcsP;
    public zzbuy.zze zzcsQ;
    public long zzcsy;
    public long zzcsz;
    public int zzrn;
    
    public zzc()
    {
      zzadf();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label83:
      label170:
      label202:
      label218:
      label234:
      label264:
      label296:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                do
                                                {
                                                  do
                                                  {
                                                    return bool1;
                                                    bool1 = bool2;
                                                  } while (!(paramObject instanceof zzc));
                                                  paramObject = (zzc)paramObject;
                                                  bool1 = bool2;
                                                } while (zzcsy != zzcsy);
                                                bool1 = bool2;
                                              } while (zzcsz != zzcsz);
                                              bool1 = bool2;
                                            } while (zzcsA != zzcsA);
                                            if (tag != null) {
                                              break;
                                            }
                                            bool1 = bool2;
                                          } while (tag != null);
                                          bool1 = bool2;
                                        } while (zzcsB != zzcsB);
                                        bool1 = bool2;
                                      } while (zzrn != zzrn);
                                      bool1 = bool2;
                                    } while (zzcbV != zzcbV);
                                    bool1 = bool2;
                                  } while (!zzbur.equals(zzcsC, zzcsC));
                                  bool1 = bool2;
                                } while (!Arrays.equals(zzcsD, zzcsD));
                                if (zzcsE != null) {
                                  break label409;
                                }
                                bool1 = bool2;
                              } while (zzcsE != null);
                              bool1 = bool2;
                            } while (!Arrays.equals(zzcsF, zzcsF));
                            if (zzcsG != null) {
                              break label425;
                            }
                            bool1 = bool2;
                          } while (zzcsG != null);
                          if (zzcsH != null) {
                            break label441;
                          }
                          bool1 = bool2;
                        } while (zzcsH != null);
                        if (zzcsI != null) {
                          break label457;
                        }
                        bool1 = bool2;
                      } while (zzcsI != null);
                      bool1 = bool2;
                    } while (zzcsJ != zzcsJ);
                    if (zzcsK != null) {
                      break label473;
                    }
                    bool1 = bool2;
                  } while (zzcsK != null);
                  bool1 = bool2;
                } while (!Arrays.equals(zzcsL, zzcsL));
                if (zzcsM != null) {
                  break label489;
                }
                bool1 = bool2;
              } while (zzcsM != null);
              bool1 = bool2;
            } while (zzcsN != zzcsN);
            bool1 = bool2;
          } while (!zzbur.equals(zzcsO, zzcsO));
          bool1 = bool2;
        } while (zzcsP != zzcsP);
        if (zzcsQ != null) {
          break label505;
        }
        bool1 = bool2;
      } while (zzcsQ != null);
      for (;;)
      {
        if ((zzcrX == null) || (zzcrX.isEmpty()))
        {
          if (zzcrX != null)
          {
            bool1 = bool2;
            if (!zzcrX.isEmpty()) {
              break;
            }
          }
          return true;
          if (tag.equals(tag)) {
            break label83;
          }
          return false;
          label409:
          if (zzcsE.equals(zzcsE)) {
            break label170;
          }
          return false;
          label425:
          if (zzcsG.equals(zzcsG)) {
            break label202;
          }
          return false;
          label441:
          if (zzcsH.equals(zzcsH)) {
            break label218;
          }
          return false;
          label457:
          if (zzcsI.equals(zzcsI)) {
            break label234;
          }
          return false;
          label473:
          if (zzcsK.equals(zzcsK)) {
            break label264;
          }
          return false;
          label489:
          if (zzcsM.equals(zzcsM)) {
            break label296;
          }
          return false;
          label505:
          if (!zzcsQ.equals(zzcsQ)) {
            return false;
          }
        }
      }
      return zzcrX.equals(zzcrX);
    }
    
    public int hashCode()
    {
      int i6 = 0;
      int i7 = getClass().getName().hashCode();
      int i8 = (int)(zzcsy ^ zzcsy >>> 32);
      int i9 = (int)(zzcsz ^ zzcsz >>> 32);
      int i10 = (int)(zzcsA ^ zzcsA >>> 32);
      int i;
      int i11;
      int i12;
      int j;
      label92:
      int i13;
      int i14;
      int k;
      label119:
      int i15;
      int m;
      label138:
      int n;
      label148:
      int i1;
      label158:
      int i16;
      int i2;
      label183:
      int i17;
      int i3;
      label202:
      int i18;
      int i19;
      int i20;
      int i4;
      if (tag == null)
      {
        i = 0;
        i11 = zzcsB;
        i12 = zzrn;
        if (!zzcbV) {
          break label420;
        }
        j = 1231;
        i13 = zzbur.hashCode(zzcsC);
        i14 = Arrays.hashCode(zzcsD);
        if (zzcsE != null) {
          break label427;
        }
        k = 0;
        i15 = Arrays.hashCode(zzcsF);
        if (zzcsG != null) {
          break label438;
        }
        m = 0;
        if (zzcsH != null) {
          break label450;
        }
        n = 0;
        if (zzcsI != null) {
          break label462;
        }
        i1 = 0;
        i16 = (int)(zzcsJ ^ zzcsJ >>> 32);
        if (zzcsK != null) {
          break label474;
        }
        i2 = 0;
        i17 = Arrays.hashCode(zzcsL);
        if (zzcsM != null) {
          break label486;
        }
        i3 = 0;
        i18 = zzcsN;
        i19 = zzbur.hashCode(zzcsO);
        i20 = (int)(zzcsP ^ zzcsP >>> 32);
        if (zzcsQ != null) {
          break label498;
        }
        i4 = 0;
        label242:
        i5 = i6;
        if (zzcrX != null) {
          if (!zzcrX.isEmpty()) {
            break label510;
          }
        }
      }
      label420:
      label427:
      label438:
      label450:
      label462:
      label474:
      label486:
      label498:
      label510:
      for (int i5 = i6;; i5 = zzcrX.hashCode())
      {
        return (i4 + ((((i3 + ((i2 + ((i1 + (n + (m + ((k + (((j + (((i + ((((i7 + 527) * 31 + i8) * 31 + i9) * 31 + i10) * 31) * 31 + i11) * 31 + i12) * 31) * 31 + i13) * 31 + i14) * 31) * 31 + i15) * 31) * 31) * 31) * 31 + i16) * 31) * 31 + i17) * 31) * 31 + i18) * 31 + i19) * 31 + i20) * 31) * 31 + i5;
        i = tag.hashCode();
        break;
        j = 1237;
        break label92;
        k = zzcsE.hashCode();
        break label119;
        m = zzcsG.hashCode();
        break label138;
        n = zzcsH.hashCode();
        break label148;
        i1 = zzcsI.hashCode();
        break label158;
        i2 = zzcsK.hashCode();
        break label183;
        i3 = zzcsM.hashCode();
        break label202;
        i4 = zzcsQ.hashCode();
        break label242;
      }
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      int j = 0;
      if (zzcsy != 0L) {
        paramZzbum.zzb(1, zzcsy);
      }
      if ((tag != null) && (!tag.equals(""))) {
        paramZzbum.zzq(2, tag);
      }
      int i;
      if ((zzcsC != null) && (zzcsC.length > 0))
      {
        i = 0;
        while (i < zzcsC.length)
        {
          zzbuy.zzd localZzd = zzcsC[i];
          if (localZzd != null) {
            paramZzbum.zza(3, localZzd);
          }
          i += 1;
        }
      }
      if (!Arrays.equals(zzcsD, zzbuw.zzcsp)) {
        paramZzbum.zzb(4, zzcsD);
      }
      if (!Arrays.equals(zzcsF, zzbuw.zzcsp)) {
        paramZzbum.zzb(6, zzcsF);
      }
      if ((zzcsG != null) && (!zzcsG.equals(""))) {
        paramZzbum.zzq(8, zzcsG);
      }
      if (zzcsE != null) {
        paramZzbum.zza(9, zzcsE);
      }
      if (zzcbV) {
        paramZzbum.zzg(10, zzcbV);
      }
      if (zzcsB != 0) {
        paramZzbum.zzF(11, zzcsB);
      }
      if (zzrn != 0) {
        paramZzbum.zzF(12, zzrn);
      }
      if ((zzcsH != null) && (!zzcsH.equals(""))) {
        paramZzbum.zzq(13, zzcsH);
      }
      if ((zzcsI != null) && (!zzcsI.equals(""))) {
        paramZzbum.zzq(14, zzcsI);
      }
      if (zzcsJ != 180000L) {
        paramZzbum.zzd(15, zzcsJ);
      }
      if (zzcsK != null) {
        paramZzbum.zza(16, zzcsK);
      }
      if (zzcsz != 0L) {
        paramZzbum.zzb(17, zzcsz);
      }
      if (!Arrays.equals(zzcsL, zzbuw.zzcsp)) {
        paramZzbum.zzb(18, zzcsL);
      }
      if (zzcsN != 0) {
        paramZzbum.zzF(19, zzcsN);
      }
      if ((zzcsO != null) && (zzcsO.length > 0))
      {
        i = j;
        while (i < zzcsO.length)
        {
          paramZzbum.zzF(20, zzcsO[i]);
          i += 1;
        }
      }
      if (zzcsA != 0L) {
        paramZzbum.zzb(21, zzcsA);
      }
      if (zzcsP != 0L) {
        paramZzbum.zzb(22, zzcsP);
      }
      if (zzcsQ != null) {
        paramZzbum.zza(23, zzcsQ);
      }
      if ((zzcsM != null) && (!zzcsM.equals(""))) {
        paramZzbum.zzq(24, zzcsM);
      }
      super.zza(paramZzbum);
    }
    
    public zzc zzaQ(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (super.zza(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          zzcsy = paramZzbul.zzacx();
          break;
        case 18: 
          tag = paramZzbul.readString();
          break;
        case 26: 
          j = zzbuw.zzc(paramZzbul, 26);
          if (zzcsC == null) {}
          for (i = 0;; i = zzcsC.length)
          {
            localObject = new zzbuy.zzd[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzcsC, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzbuy.zzd();
              paramZzbul.zza(localObject[j]);
              paramZzbul.zzacu();
              j += 1;
            }
          }
          localObject[j] = new zzbuy.zzd();
          paramZzbul.zza(localObject[j]);
          zzcsC = ((zzbuy.zzd[])localObject);
          break;
        case 34: 
          zzcsD = paramZzbul.readBytes();
          break;
        case 50: 
          zzcsF = paramZzbul.readBytes();
          break;
        case 66: 
          zzcsG = paramZzbul.readString();
          break;
        case 74: 
          if (zzcsE == null) {
            zzcsE = new zzbuy.zza();
          }
          paramZzbul.zza(zzcsE);
          break;
        case 80: 
          zzcbV = paramZzbul.zzacA();
          break;
        case 88: 
          zzcsB = paramZzbul.zzacy();
          break;
        case 96: 
          zzrn = paramZzbul.zzacy();
          break;
        case 106: 
          zzcsH = paramZzbul.readString();
          break;
        case 114: 
          zzcsI = paramZzbul.readString();
          break;
        case 120: 
          zzcsJ = paramZzbul.zzacC();
          break;
        case 130: 
          if (zzcsK == null) {
            zzcsK = new zzbuy.zzb();
          }
          paramZzbul.zza(zzcsK);
          break;
        case 136: 
          zzcsz = paramZzbul.zzacx();
          break;
        case 146: 
          zzcsL = paramZzbul.readBytes();
          break;
        case 152: 
          i = paramZzbul.zzacy();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
            zzcsN = i;
          }
          break;
        case 160: 
          j = zzbuw.zzc(paramZzbul, 160);
          if (zzcsO == null) {}
          for (i = 0;; i = zzcsO.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzcsO, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramZzbul.zzacy();
              paramZzbul.zzacu();
              j += 1;
            }
          }
          localObject[j] = paramZzbul.zzacy();
          zzcsO = ((int[])localObject);
          break;
        case 162: 
          int k = paramZzbul.zzqj(paramZzbul.zzacD());
          i = paramZzbul.getPosition();
          j = 0;
          while (paramZzbul.zzacI() > 0)
          {
            paramZzbul.zzacy();
            j += 1;
          }
          paramZzbul.zzql(i);
          if (zzcsO == null) {}
          for (i = 0;; i = zzcsO.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzcsO, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramZzbul.zzacy();
              j += 1;
            }
          }
          zzcsO = ((int[])localObject);
          paramZzbul.zzqk(k);
          break;
        case 168: 
          zzcsA = paramZzbul.zzacx();
          break;
        case 176: 
          zzcsP = paramZzbul.zzacx();
          break;
        case 186: 
          if (zzcsQ == null) {
            zzcsQ = new zzbuy.zze();
          }
          paramZzbul.zza(zzcsQ);
          break;
        case 194: 
          zzcsM = paramZzbul.readString();
        }
      }
    }
    
    public zzc zzadf()
    {
      zzcsy = 0L;
      zzcsz = 0L;
      zzcsA = 0L;
      tag = "";
      zzcsB = 0;
      zzrn = 0;
      zzcbV = false;
      zzcsC = zzbuy.zzd.zzadh();
      zzcsD = zzbuw.zzcsp;
      zzcsE = null;
      zzcsF = zzbuw.zzcsp;
      zzcsG = "";
      zzcsH = "";
      zzcsI = "";
      zzcsJ = 180000L;
      zzcsK = null;
      zzcsL = zzbuw.zzcsp;
      zzcsM = "";
      zzcsN = 0;
      zzcsO = zzbuw.zzcsi;
      zzcsP = 0L;
      zzcsQ = null;
      zzcrX = null;
      zzcsg = -1;
      return this;
    }
    
    public zzc zzadg()
    {
      try
      {
        zzc localZzc = (zzc)super.zzacN();
        if ((zzcsC != null) && (zzcsC.length > 0))
        {
          zzcsC = new zzbuy.zzd[zzcsC.length];
          int i = 0;
          while (i < zzcsC.length)
          {
            if (zzcsC[i] != null) {
              zzcsC[i] = ((zzbuy.zzd)(Object)zzcsC[i].zzacO());
            }
            i += 1;
          }
        }
        if (zzcsE == null) {
          break label117;
        }
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
      zzcsE = ((zzbuy.zza)zzcsE.zzacO());
      label117:
      if (zzcsK != null) {
        zzcsK = ((zzbuy.zzb)zzcsK.zzacO());
      }
      if ((zzcsO != null) && (zzcsO.length > 0)) {
        zzcsO = ((int[])zzcsO.clone());
      }
      if (zzcsQ != null) {
        zzcsQ = ((zzbuy.zze)zzcsQ.zzacO());
      }
      return localCloneNotSupportedException;
    }
    
    protected int zzv()
    {
      int m = 0;
      int i = super.zzv();
      int j = i;
      if (zzcsy != 0L) {
        j = i + zzbum.zzf(1, zzcsy);
      }
      i = j;
      if (tag != null)
      {
        i = j;
        if (!tag.equals("")) {
          i = j + zzbum.zzr(2, tag);
        }
      }
      j = i;
      if (zzcsC != null)
      {
        j = i;
        if (zzcsC.length > 0)
        {
          j = 0;
          while (j < zzcsC.length)
          {
            zzbuy.zzd localZzd = zzcsC[j];
            k = i;
            if (localZzd != null) {
              k = i + zzbum.zzc(3, localZzd);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!Arrays.equals(zzcsD, zzbuw.zzcsp)) {
        i = j + zzbum.zzc(4, zzcsD);
      }
      j = i;
      if (!Arrays.equals(zzcsF, zzbuw.zzcsp)) {
        j = i + zzbum.zzc(6, zzcsF);
      }
      i = j;
      if (zzcsG != null)
      {
        i = j;
        if (!zzcsG.equals("")) {
          i = j + zzbum.zzr(8, zzcsG);
        }
      }
      j = i;
      if (zzcsE != null) {
        j = i + zzbum.zzc(9, zzcsE);
      }
      i = j;
      if (zzcbV) {
        i = j + zzbum.zzh(10, zzcbV);
      }
      j = i;
      if (zzcsB != 0) {
        j = i + zzbum.zzH(11, zzcsB);
      }
      i = j;
      if (zzrn != 0) {
        i = j + zzbum.zzH(12, zzrn);
      }
      j = i;
      if (zzcsH != null)
      {
        j = i;
        if (!zzcsH.equals("")) {
          j = i + zzbum.zzr(13, zzcsH);
        }
      }
      i = j;
      if (zzcsI != null)
      {
        i = j;
        if (!zzcsI.equals("")) {
          i = j + zzbum.zzr(14, zzcsI);
        }
      }
      j = i;
      if (zzcsJ != 180000L) {
        j = i + zzbum.zzh(15, zzcsJ);
      }
      i = j;
      if (zzcsK != null) {
        i = j + zzbum.zzc(16, zzcsK);
      }
      j = i;
      if (zzcsz != 0L) {
        j = i + zzbum.zzf(17, zzcsz);
      }
      int k = j;
      if (!Arrays.equals(zzcsL, zzbuw.zzcsp)) {
        k = j + zzbum.zzc(18, zzcsL);
      }
      i = k;
      if (zzcsN != 0) {
        i = k + zzbum.zzH(19, zzcsN);
      }
      j = i;
      if (zzcsO != null)
      {
        j = i;
        if (zzcsO.length > 0)
        {
          k = 0;
          j = m;
          while (j < zzcsO.length)
          {
            k += zzbum.zzqp(zzcsO[j]);
            j += 1;
          }
          j = i + k + zzcsO.length * 2;
        }
      }
      i = j;
      if (zzcsA != 0L) {
        i = j + zzbum.zzf(21, zzcsA);
      }
      j = i;
      if (zzcsP != 0L) {
        j = i + zzbum.zzf(22, zzcsP);
      }
      i = j;
      if (zzcsQ != null) {
        i = j + zzbum.zzc(23, zzcsQ);
      }
      j = i;
      if (zzcsM != null)
      {
        j = i;
        if (!zzcsM.equals("")) {
          j = i + zzbum.zzr(24, zzcsM);
        }
      }
      return j;
    }
  }
  
  public static final class zzd
    extends zzbun<zzd>
    implements Cloneable
  {
    private static volatile zzd[] zzcsR;
    public String value;
    public String zzaA;
    
    public zzd()
    {
      zzadi();
    }
    
    public static zzd[] zzadh()
    {
      if (zzcsR == null) {}
      synchronized (zzbur.zzcsf)
      {
        if (zzcsR == null) {
          zzcsR = new zzd[0];
        }
        return zzcsR;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label41:
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zzd));
          paramObject = (zzd)paramObject;
          if (zzaA != null) {
            break;
          }
          bool1 = bool2;
        } while (zzaA != null);
        if (value != null) {
          break label111;
        }
        bool1 = bool2;
      } while (value != null);
      for (;;)
      {
        if ((zzcrX == null) || (zzcrX.isEmpty()))
        {
          if (zzcrX != null)
          {
            bool1 = bool2;
            if (!zzcrX.isEmpty()) {
              break;
            }
          }
          return true;
          if (zzaA.equals(zzaA)) {
            break label41;
          }
          return false;
          label111:
          if (!value.equals(value)) {
            return false;
          }
        }
      }
      return zzcrX.equals(zzcrX);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      if (zzaA == null)
      {
        i = 0;
        if (value != null) {
          break label89;
        }
        j = 0;
        label33:
        k = m;
        if (zzcrX != null) {
          if (!zzcrX.isEmpty()) {
            break label100;
          }
        }
      }
      label89:
      label100:
      for (int k = m;; k = zzcrX.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = zzaA.hashCode();
        break;
        j = value.hashCode();
        break label33;
      }
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if ((zzaA != null) && (!zzaA.equals(""))) {
        paramZzbum.zzq(1, zzaA);
      }
      if ((value != null) && (!value.equals(""))) {
        paramZzbum.zzq(2, value);
      }
      super.zza(paramZzbum);
    }
    
    public zzd zzaR(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (super.zza(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          zzaA = paramZzbul.readString();
          break;
        case 18: 
          value = paramZzbul.readString();
        }
      }
    }
    
    public zzd zzadi()
    {
      zzaA = "";
      value = "";
      zzcrX = null;
      zzcsg = -1;
      return this;
    }
    
    public zzd zzadj()
    {
      try
      {
        zzd localZzd = (zzd)super.zzacN();
        return localZzd;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    protected int zzv()
    {
      int j = super.zzv();
      int i = j;
      if (zzaA != null)
      {
        i = j;
        if (!zzaA.equals("")) {
          i = j + zzbum.zzr(1, zzaA);
        }
      }
      j = i;
      if (value != null)
      {
        j = i;
        if (!value.equals("")) {
          j = i + zzbum.zzr(2, value);
        }
      }
      return j;
    }
  }
  
  public static final class zze
    extends zzbun<zze>
    implements Cloneable
  {
    public int zzcsS;
    public int zzcsT;
    
    public zze()
    {
      zzadk();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof zze));
            paramObject = (zze)paramObject;
            bool1 = bool2;
          } while (zzcsS != zzcsS);
          bool1 = bool2;
        } while (zzcsT != zzcsT);
        if ((zzcrX != null) && (!zzcrX.isEmpty())) {
          break label89;
        }
        if (zzcrX == null) {
          break;
        }
        bool1 = bool2;
      } while (!zzcrX.isEmpty());
      return true;
      label89:
      return zzcrX.equals(zzcrX);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzcsS;
      int m = zzcsT;
      if ((zzcrX == null) || (zzcrX.isEmpty())) {}
      for (int i = 0;; i = zzcrX.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
    
    public void zza(zzbum paramZzbum)
      throws IOException
    {
      if (zzcsS != -1) {
        paramZzbum.zzF(1, zzcsS);
      }
      if (zzcsT != 0) {
        paramZzbum.zzF(2, zzcsT);
      }
      super.zza(paramZzbum);
    }
    
    public zze zzaS(zzbul paramZzbul)
      throws IOException
    {
      for (;;)
      {
        int i = paramZzbul.zzacu();
        switch (i)
        {
        default: 
          if (super.zza(paramZzbul, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          i = paramZzbul.zzacy();
          switch (i)
          {
          default: 
            break;
          case -1: 
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
            zzcsS = i;
          }
          break;
        case 16: 
          i = paramZzbul.zzacy();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 100: 
            zzcsT = i;
          }
          break;
        }
      }
    }
    
    public zze zzadk()
    {
      zzcsS = -1;
      zzcsT = 0;
      zzcrX = null;
      zzcsg = -1;
      return this;
    }
    
    public zze zzadl()
    {
      try
      {
        zze localZze = (zze)super.zzacN();
        return localZze;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError(localCloneNotSupportedException);
      }
    }
    
    protected int zzv()
    {
      int j = super.zzv();
      int i = j;
      if (zzcsS != -1) {
        i = j + zzbum.zzH(1, zzcsS);
      }
      j = i;
      if (zzcsT != 0) {
        j = i + zzbum.zzH(2, zzcsT);
      }
      return j;
    }
  }
}
