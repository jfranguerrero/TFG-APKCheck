.class public Lcom/guillefix/frasesdelfary/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# instance fields
.field private final REQUEST_CODE_ASK_PERMISSIONS:I

.field private final buttonIds:[I

.field private player:Landroid/media/MediaPlayer;

.field private res:Landroid/content/res/Resources;

.field selectedSoundId:I

.field final soundIds:[I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/16 v1, 0x16

    .line 34
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 38
    const/16 v0, 0x7b

    iput v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->REQUEST_CODE_ASK_PERMISSIONS:I

    .line 41
    new-array v0, v1, [I

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I

    .line 66
    new-array v0, v1, [I

    fill-array-data v0, :array_1

    iput-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->soundIds:[I

    return-void

    .line 41
    :array_0
    .array-data 4
        0x7f0f007d
        0x7f0f007e
        0x7f0f007f
        0x7f0f0080
        0x7f0f0081
        0x7f0f0082
        0x7f0f0083
        0x7f0f0084
        0x7f0f0085
        0x7f0f0086
        0x7f0f0087
        0x7f0f0088
        0x7f0f0089
        0x7f0f008a
        0x7f0f008b
        0x7f0f008c
        0x7f0f008d
        0x7f0f008e
        0x7f0f008f
        0x7f0f0090
        0x7f0f0091
        0x7f0f0092
    .end array-data

    .line 66
    :array_1
    .array-data 4
        0x7f080000
        0x7f080001
        0x7f080002
        0x7f080003
        0x7f080004
        0x7f080005
        0x7f080006
        0x7f080007
        0x7f080008
        0x7f080009
        0x7f08000a
        0x7f08000b
        0x7f08000c
        0x7f08000d
        0x7f08000e
        0x7f08000f
        0x7f080010
        0x7f080011
        0x7f080012
        0x7f080013
        0x7f080014
        0x7f080015
    .end array-data
.end method

.method static synthetic access$000(Lcom/guillefix/frasesdelfary/MainActivity;)[I
    .locals 1
    .param p0, "x0"    # Lcom/guillefix/frasesdelfary/MainActivity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I

    return-object v0
.end method

.method static synthetic access$100(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/content/res/Resources;
    .locals 1
    .param p0, "x0"    # Lcom/guillefix/frasesdelfary/MainActivity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->res:Landroid/content/res/Resources;

    return-object v0
.end method

.method static synthetic access$200(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;
    .locals 1
    .param p0, "x0"    # Lcom/guillefix/frasesdelfary/MainActivity;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;

    return-object v0
.end method

.method private playRandomSound()V
    .locals 9

    .prologue
    .line 374
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v0

    iget-object v2, p0, Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I

    array-length v2, v2

    int-to-double v2, v2

    mul-double/2addr v0, v2

    double-to-int v8, v0

    .line 376
    .local v8, "sonido":I
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->res:Landroid/content/res/Resources;

    iget-object v1, p0, Lcom/guillefix/frasesdelfary/MainActivity;->soundIds:[I

    aget v1, v1, v8

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->openRawResourceFd(I)Landroid/content/res/AssetFileDescriptor;

    move-result-object v6

    .line 377
    .local v6, "afd":Landroid/content/res/AssetFileDescriptor;
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 379
    :try_start_0
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v1

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getStartOffset()J

    move-result-wide v2

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getLength()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Landroid/media/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;JJ)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    .line 391
    :goto_0
    :try_start_1
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->prepare()V
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4

    .line 399
    :goto_1
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 401
    return-void

    .line 380
    :catch_0
    move-exception v7

    .line 382
    .local v7, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v7}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_0

    .line 383
    .end local v7    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v7

    .line 385
    .local v7, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v7}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_0

    .line 386
    .end local v7    # "e":Ljava/lang/IllegalStateException;
    :catch_2
    move-exception v7

    .line 388
    .local v7, "e":Ljava/io/IOException;
    invoke-virtual {v7}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 392
    .end local v7    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v7

    .line 394
    .local v7, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v7}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_1

    .line 395
    .end local v7    # "e":Ljava/lang/IllegalStateException;
    :catch_4
    move-exception v7

    .line 397
    .local v7, "e":Ljava/io/IOException;
    invoke-virtual {v7}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method

.method private randomYoutubeVideo()V
    .locals 6

    .prologue
    .line 412
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 415
    .local v4, "videoList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v5, "https://www.youtube.com/watch?v=WosrUnjb2UQ"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 417
    const-string v5, "https://www.youtube.com/watch?v=SX8HPD3jIT0"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 419
    const-string v5, "https://www.youtube.com/watch?v=HgjQGGZiy-k"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 421
    const-string v5, "https://www.youtube.com/watch?v=ladsmDRCMyU"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 423
    const-string v5, "https://www.youtube.com/watch?v=HHenQqsI6Xo"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 425
    const-string v5, "https://www.youtube.com/watch?v=yv-zM2gR9uw"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 427
    const-string v5, "https://www.youtube.com/watch?v=i0IwVSW7occ"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 429
    const-string v5, "https://www.youtube.com/watch?v=LEV4NN_fqHU"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 431
    const-string v5, "https://www.youtube.com/watch?v=WDnxMkP7ew0"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 433
    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    .line 434
    .local v2, "rand":Ljava/util/Random;
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v5

    invoke-virtual {v2, v5}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    .line 436
    .local v1, "n":I
    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 438
    .local v3, "urlVideo":Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;

    const-string v5, "android.intent.action.VIEW"

    invoke-direct {v0, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 439
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v0, v5}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 440
    invoke-virtual {p0, v0}, Lcom/guillefix/frasesdelfary/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 441
    return-void
.end method

.method private showInstrucciones()V
    .locals 3

    .prologue
    .line 356
    new-instance v0, Landroid/support/v7/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 358
    .local v0, "builder":Landroid/support/v7/app/AlertDialog$Builder;
    const v1, 0x7f090045

    new-instance v2, Lcom/guillefix/frasesdelfary/MainActivity$4;

    invoke-direct {v2, p0}, Lcom/guillefix/frasesdelfary/MainActivity$4;-><init>(Lcom/guillefix/frasesdelfary/MainActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 365
    const v1, 0x7f090043

    invoke-virtual {p0, v1}, Lcom/guillefix/frasesdelfary/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/support/v7/app/AlertDialog$Builder;

    move-result-object v1

    const v2, 0x7f090044

    invoke-virtual {v1, v2}, Landroid/support/v7/app/AlertDialog$Builder;->setTitle(I)Landroid/support/v7/app/AlertDialog$Builder;

    .line 369
    invoke-virtual {v0}, Landroid/support/v7/app/AlertDialog$Builder;->create()Landroid/support/v7/app/AlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 370
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 96
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 97
    const v6, 0x7f04001b

    invoke-virtual {p0, v6}, Lcom/guillefix/frasesdelfary/MainActivity;->setContentView(I)V

    .line 99
    const v6, 0x7f0f007b

    invoke-virtual {p0, v6}, Lcom/guillefix/frasesdelfary/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/ads/AdView;

    .line 100
    .local v4, "mAdView":Lcom/google/android/gms/ads/AdView;
    new-instance v6, Lcom/google/android/gms/ads/AdRequest$Builder;

    invoke-direct {v6}, Lcom/google/android/gms/ads/AdRequest$Builder;-><init>()V

    invoke-virtual {v6}, Lcom/google/android/gms/ads/AdRequest$Builder;->build()Lcom/google/android/gms/ads/AdRequest;

    move-result-object v0

    .line 101
    .local v0, "adRequest":Lcom/google/android/gms/ads/AdRequest;
    invoke-virtual {v4, v0}, Lcom/google/android/gms/ads/AdView;->loadAd(Lcom/google/android/gms/ads/AdRequest;)V

    .line 103
    new-instance v6, Landroid/media/MediaPlayer;

    invoke-direct {v6}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v6, p0, Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;

    .line 104
    invoke-virtual {p0}, Lcom/guillefix/frasesdelfary/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    iput-object v6, p0, Lcom/guillefix/frasesdelfary/MainActivity;->res:Landroid/content/res/Resources;

    .line 106
    new-instance v2, Lcom/guillefix/frasesdelfary/MainActivity$1;

    invoke-direct {v2, p0}, Lcom/guillefix/frasesdelfary/MainActivity$1;-><init>(Lcom/guillefix/frasesdelfary/MainActivity;)V

    .line 144
    .local v2, "listener":Landroid/view/View$OnClickListener;
    new-instance v3, Lcom/guillefix/frasesdelfary/MainActivity$2;

    invoke-direct {v3, p0}, Lcom/guillefix/frasesdelfary/MainActivity$2;-><init>(Lcom/guillefix/frasesdelfary/MainActivity;)V

    .line 236
    .local v3, "listener2":Landroid/view/View$OnLongClickListener;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v6, p0, Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I

    array-length v6, v6

    if-ge v1, v6, :cond_0

    .line 237
    iget-object v6, p0, Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I

    aget v6, v6, v1

    invoke-virtual {p0, v6}, Lcom/guillefix/frasesdelfary/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    .line 238
    .local v5, "soundButton":Landroid/widget/Button;
    invoke-virtual {p0, v5}, Lcom/guillefix/frasesdelfary/MainActivity;->registerForContextMenu(Landroid/view/View;)V

    .line 239
    invoke-virtual {v5, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 240
    invoke-virtual {v5, v3}, Landroid/widget/Button;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 236
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 242
    .end local v5    # "soundButton":Landroid/widget/Button;
    :cond_0
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 270
    invoke-virtual {p0}, Lcom/guillefix/frasesdelfary/MainActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v1

    const/high16 v2, 0x7f100000

    invoke-virtual {v1, v2, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 272
    const v1, 0x7f0f00b8

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/SearchView;

    .line 273
    .local v0, "searchView":Landroid/support/v7/widget/SearchView;
    new-instance v1, Lcom/guillefix/frasesdelfary/MainActivity$3;

    invoke-direct {v1, p0}, Lcom/guillefix/frasesdelfary/MainActivity$3;-><init>(Lcom/guillefix/frasesdelfary/MainActivity;)V

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/SearchView;->setOnQueryTextListener(Landroid/support/v7/widget/SearchView$OnQueryTextListener;)V

    .line 301
    const/4 v1, 0x1

    return v1
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 8
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v4, 0x1

    .line 310
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    .line 313
    .local v0, "id":I
    const v5, 0x7f0f00bb

    if-ne v0, v5, :cond_0

    .line 314
    const-string v2, "https://play.google.com/store/apps/details?id=com.guillefix.frasesdelfary"

    .line 315
    .local v2, "shareBody":Ljava/lang/String;
    new-instance v3, Landroid/content/Intent;

    const-string v5, "android.intent.action.SEND"

    invoke-direct {v3, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 316
    .local v3, "sharingIntent":Landroid/content/Intent;
    const-string v5, "text/plain"

    invoke-virtual {v3, v5}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 317
    const-string v5, "android.intent.extra.SUBJECT"

    const-string v6, "Compartir enlace a Play Store"

    invoke-virtual {v3, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 318
    const-string v5, "android.intent.extra.TEXT"

    invoke-virtual {v3, v5, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 319
    const-string v5, "Compartir enlace de la app"

    invoke-static {v3, v5}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/guillefix/frasesdelfary/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 351
    .end local v2    # "shareBody":Ljava/lang/String;
    .end local v3    # "sharingIntent":Landroid/content/Intent;
    :goto_0
    return v4

    .line 324
    :cond_0
    const v5, 0x7f0f00bc

    if-ne v0, v5, :cond_1

    .line 325
    new-instance v1, Landroid/content/Intent;

    const-string v5, "android.intent.action.SEND"

    invoke-direct {v1, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 326
    .local v1, "intent":Landroid/content/Intent;
    const-string v5, "plain/text"

    invoke-virtual {v1, v5}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 327
    const-string v5, "android.intent.extra.EMAIL"

    new-array v4, v4, [Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "fanchewbacca@gmail.com"

    aput-object v7, v4, v6

    invoke-virtual {v1, v5, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Ljava/lang/String;)Landroid/content/Intent;

    .line 328
    const-string v4, "android.intent.extra.SUBJECT"

    const-string v5, "Frases del Fary"

    invoke-virtual {v1, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 329
    const-string v4, ""

    invoke-static {v1, v4}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/guillefix/frasesdelfary/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 332
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    const v4, 0x7f0f00ba

    if-ne v0, v4, :cond_2

    .line 333
    invoke-direct {p0}, Lcom/guillefix/frasesdelfary/MainActivity;->playRandomSound()V

    .line 336
    :cond_2
    const v4, 0x7f0f00b9

    if-ne v0, v4, :cond_3

    .line 337
    invoke-direct {p0}, Lcom/guillefix/frasesdelfary/MainActivity;->showInstrucciones()V

    .line 341
    :cond_3
    const v4, 0x7f0f00bd

    if-ne v0, v4, :cond_4

    .line 342
    invoke-direct {p0}, Lcom/guillefix/frasesdelfary/MainActivity;->randomYoutubeVideo()V

    .line 345
    :cond_4
    const v4, 0x7f0f00be

    if-ne v0, v4, :cond_5

    .line 346
    new-instance v1, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v1, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 347
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v4, "market://details?id=com.guillefix.frasesdelfary"

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 348
    invoke-virtual {p0, v1}, Lcom/guillefix/frasesdelfary/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 351
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_5
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v4

    goto :goto_0
.end method

.method public onRequestPermissionsResult(I[Ljava/lang/String;[I)V
    .locals 4
    .param p1, "requestCode"    # I
    .param p2, "permissions"    # [Ljava/lang/String;
    .param p3, "grantResults"    # [I

    .prologue
    const/4 v3, 0x1

    .line 246
    packed-switch p1, :pswitch_data_0

    .line 265
    :goto_0
    return-void

    .line 249
    :pswitch_0
    array-length v1, p3

    if-lez v1, :cond_0

    const/4 v1, 0x0

    aget v1, p3, v1

    if-nez v1, :cond_0

    .line 251
    invoke-virtual {p0}, Lcom/guillefix/frasesdelfary/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "Los permisos han sido concedidos"

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 252
    .local v0, "toast":Landroid/widget/Toast;
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 256
    .end local v0    # "toast":Landroid/widget/Toast;
    :cond_0
    invoke-virtual {p0}, Lcom/guillefix/frasesdelfary/MainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "Los permisos no han sido concedidos"

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 257
    .restart local v0    # "toast":Landroid/widget/Toast;
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 246
    nop

    :pswitch_data_0
    .packed-switch 0x7b
        :pswitch_0
    .end packed-switch
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 405
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 407
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V

    .line 408
    return-void
.end method
