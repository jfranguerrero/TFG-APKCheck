.class Lcom/guillefix/frasesdelfary/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 106
    iput-object p1, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 111
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I
    invoke-static {v0}, Lcom/guillefix/frasesdelfary/MainActivity;->access$000(Lcom/guillefix/frasesdelfary/MainActivity;)[I

    move-result-object v0

    array-length v0, v0

    if-ge v8, v0, :cond_0

    .line 112
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    iget-object v1, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I
    invoke-static {v1}, Lcom/guillefix/frasesdelfary/MainActivity;->access$000(Lcom/guillefix/frasesdelfary/MainActivity;)[I

    move-result-object v1

    aget v1, v1, v8

    if-ne v0, v1, :cond_1

    .line 113
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget-object v1, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget-object v1, v1, Lcom/guillefix/frasesdelfary/MainActivity;->soundIds:[I

    aget v1, v1, v8

    iput v1, v0, Lcom/guillefix/frasesdelfary/MainActivity;->selectedSoundId:I

    .line 114
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->res:Landroid/content/res/Resources;
    invoke-static {v0}, Lcom/guillefix/frasesdelfary/MainActivity;->access$100(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/content/res/Resources;

    move-result-object v0

    iget-object v1, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget-object v1, v1, Lcom/guillefix/frasesdelfary/MainActivity;->soundIds:[I

    aget v1, v1, v8

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->openRawResourceFd(I)Landroid/content/res/AssetFileDescriptor;

    move-result-object v6

    .line 115
    .local v6, "afd":Landroid/content/res/AssetFileDescriptor;
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;
    invoke-static {v0}, Lcom/guillefix/frasesdelfary/MainActivity;->access$200(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 117
    :try_start_0
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;
    invoke-static {v0}, Lcom/guillefix/frasesdelfary/MainActivity;->access$200(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;

    move-result-object v0

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

    .line 129
    :goto_1
    :try_start_1
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;
    invoke-static {v0}, Lcom/guillefix/frasesdelfary/MainActivity;->access$200(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->prepare()V
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4

    .line 137
    :goto_2
    iget-object v0, p0, Lcom/guillefix/frasesdelfary/MainActivity$1;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->player:Landroid/media/MediaPlayer;
    invoke-static {v0}, Lcom/guillefix/frasesdelfary/MainActivity;->access$200(Lcom/guillefix/frasesdelfary/MainActivity;)Landroid/media/MediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 141
    .end local v6    # "afd":Landroid/content/res/AssetFileDescriptor;
    :cond_0
    return-void

    .line 118
    .restart local v6    # "afd":Landroid/content/res/AssetFileDescriptor;
    :catch_0
    move-exception v7

    .line 120
    .local v7, "e":Ljava/lang/IllegalArgumentException;
    invoke-virtual {v7}, Ljava/lang/IllegalArgumentException;->printStackTrace()V

    goto :goto_1

    .line 121
    .end local v7    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v7

    .line 123
    .local v7, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v7}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_1

    .line 124
    .end local v7    # "e":Ljava/lang/IllegalStateException;
    :catch_2
    move-exception v7

    .line 126
    .local v7, "e":Ljava/io/IOException;
    invoke-virtual {v7}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 130
    .end local v7    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v7

    .line 132
    .local v7, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v7}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_2

    .line 133
    .end local v7    # "e":Ljava/lang/IllegalStateException;
    :catch_4
    move-exception v7

    .line 135
    .local v7, "e":Ljava/io/IOException;
    invoke-virtual {v7}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_2

    .line 111
    .end local v6    # "afd":Landroid/content/res/AssetFileDescriptor;
    .end local v7    # "e":Ljava/io/IOException;
    :cond_1
    add-int/lit8 v8, v8, 0x1

    goto :goto_0
.end method
