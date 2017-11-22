.class Lcom/guillefix/frasesdelfary/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/guillefix/frasesdelfary/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/guillefix/frasesdelfary/MainActivity;


# direct methods
.method constructor <init>(Lcom/guillefix/frasesdelfary/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/guillefix/frasesdelfary/MainActivity;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 15
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 149
    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    const-string v11, "android.permission.READ_EXTERNAL_STORAGE"

    invoke-static {v10, v11}, Landroid/support/v4/app/ActivityCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v10

    if-nez v10, :cond_0

    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    const-string v11, "android.permission.WRITE_EXTERNAL_STORAGE"

    .line 150
    invoke-static {v10, v11}, Landroid/support/v4/app/ActivityCompat;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v10

    if-eqz v10, :cond_2

    .line 173
    :cond_0
    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/String;

    const/4 v12, 0x0

    const-string v13, "android.permission.READ_EXTERNAL_STORAGE"

    aput-object v13, v11, v12

    const/4 v12, 0x1

    const-string v13, "android.permission.WRITE_EXTERNAL_STORAGE"

    aput-object v13, v11, v12

    const/16 v12, 0x7b

    invoke-static {v10, v11, v12}, Landroid/support/v4/app/ActivityCompat;->requestPermissions(Landroid/app/Activity;[Ljava/lang/String;I)V

    .line 230
    :cond_1
    :goto_0
    const/4 v10, 0x0

    :goto_1
    return v10

    .line 180
    :cond_2
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_2
    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I
    invoke-static {v10}, Lcom/guillefix/frasesdelfary/MainActivity;->access$000(Lcom/guillefix/frasesdelfary/MainActivity;)[I

    move-result-object v10

    array-length v10, v10

    if-ge v5, v10, :cond_1

    .line 182
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v10

    iget-object v11, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I
    invoke-static {v11}, Lcom/guillefix/frasesdelfary/MainActivity;->access$000(Lcom/guillefix/frasesdelfary/MainActivity;)[I

    move-result-object v11

    aget v11, v11, v5

    if-ne v10, v11, :cond_4

    .line 184
    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget-object v11, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget-object v11, v11, Lcom/guillefix/frasesdelfary/MainActivity;->soundIds:[I

    aget v11, v11, v5

    iput v11, v10, Lcom/guillefix/frasesdelfary/MainActivity;->selectedSoundId:I

    .line 186
    const/4 v0, 0x0

    .line 187
    .local v0, "buffer":[B
    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    invoke-virtual {v10}, Lcom/guillefix/frasesdelfary/MainActivity;->getBaseContext()Landroid/content/Context;

    move-result-object v10

    invoke-virtual {v10}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    iget-object v11, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget v11, v11, Lcom/guillefix/frasesdelfary/MainActivity;->selectedSoundId:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 188
    .local v3, "fIn":Ljava/io/InputStream;
    const/4 v9, 0x0

    .line 191
    .local v9, "size":I
    :try_start_0
    invoke-virtual {v3}, Ljava/io/InputStream;->available()I

    move-result v9

    .line 192
    new-array v0, v9, [B

    .line 193
    invoke-virtual {v3, v0}, Ljava/io/InputStream;->read([B)I

    .line 194
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 200
    const-string v6, "/sdcard/media/audio/share/"

    .line 201
    .local v6, "path":Ljava/lang/String;
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v11, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    invoke-virtual {v11}, Lcom/guillefix/frasesdelfary/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    iget-object v12, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget v12, v12, Lcom/guillefix/frasesdelfary/MainActivity;->selectedSoundId:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getResourceEntryName(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ".mp3"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 203
    .local v4, "filename":Ljava/lang/String;
    new-instance v10, Ljava/io/File;

    invoke-direct {v10, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/io/File;->exists()Z

    move-result v2

    .line 204
    .local v2, "exists":Z
    if-nez v2, :cond_3

    new-instance v10, Ljava/io/File;

    invoke-direct {v10, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10}, Ljava/io/File;->mkdirs()Z

    .line 208
    :cond_3
    :try_start_1
    new-instance v7, Ljava/io/FileOutputStream;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v7, v10}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    .line 209
    .local v7, "save":Ljava/io/FileOutputStream;
    invoke-virtual {v7, v0}, Ljava/io/FileOutputStream;->write([B)V

    .line 210
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->flush()V

    .line 211
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 218
    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    new-instance v11, Landroid/content/Intent;

    const-string v12, "android.intent.action.MEDIA_SCANNER_SCAN_FILE"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "file://"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v13

    invoke-direct {v11, v12, v13}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v10, v11}, Lcom/guillefix/frasesdelfary/MainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 220
    new-instance v8, Landroid/content/Intent;

    const-string v10, "android.intent.action.SEND"

    invoke-direct {v8, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 221
    .local v8, "shareIntent":Landroid/content/Intent;
    const-string v10, "audio/mp3"

    invoke-virtual {v8, v10}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 222
    const-string v10, "android.intent.extra.STREAM"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "file://"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v11

    invoke-virtual {v8, v10, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 223
    iget-object v10, p0, Lcom/guillefix/frasesdelfary/MainActivity$2;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    const-string v11, "Enviar frase:"

    invoke-static {v8, v11}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/guillefix/frasesdelfary/MainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 195
    .end local v2    # "exists":Z
    .end local v4    # "filename":Ljava/lang/String;
    .end local v6    # "path":Ljava/lang/String;
    .end local v7    # "save":Ljava/io/FileOutputStream;
    .end local v8    # "shareIntent":Landroid/content/Intent;
    :catch_0
    move-exception v1

    .line 197
    .local v1, "e":Ljava/io/IOException;
    const/4 v10, 0x0

    goto/16 :goto_1

    .line 212
    .end local v1    # "e":Ljava/io/IOException;
    .restart local v2    # "exists":Z
    .restart local v4    # "filename":Ljava/lang/String;
    .restart local v6    # "path":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 213
    .local v1, "e":Ljava/io/FileNotFoundException;
    const/4 v10, 0x0

    goto/16 :goto_1

    .line 214
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    :catch_2
    move-exception v1

    .line 215
    .local v1, "e":Ljava/io/IOException;
    const/4 v10, 0x0

    goto/16 :goto_1

    .line 180
    .end local v0    # "buffer":[B
    .end local v1    # "e":Ljava/io/IOException;
    .end local v2    # "exists":Z
    .end local v3    # "fIn":Ljava/io/InputStream;
    .end local v4    # "filename":Ljava/lang/String;
    .end local v6    # "path":Ljava/lang/String;
    .end local v9    # "size":I
    :cond_4
    add-int/lit8 v5, v5, 0x1

    goto/16 :goto_2
.end method
