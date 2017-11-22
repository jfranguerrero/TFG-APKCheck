.class Lcom/guillefix/frasesdelfary/MainActivity$3;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/support/v7/widget/SearchView$OnQueryTextListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/guillefix/frasesdelfary/MainActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z
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
    .line 273
    iput-object p1, p0, Lcom/guillefix/frasesdelfary/MainActivity$3;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private buscarFrases(Ljava/lang/String;)V
    .locals 5
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 288
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Lcom/guillefix/frasesdelfary/MainActivity$3;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I
    invoke-static {v3}, Lcom/guillefix/frasesdelfary/MainActivity;->access$000(Lcom/guillefix/frasesdelfary/MainActivity;)[I

    move-result-object v3

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 289
    iget-object v3, p0, Lcom/guillefix/frasesdelfary/MainActivity$3;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    iget-object v4, p0, Lcom/guillefix/frasesdelfary/MainActivity$3;->this$0:Lcom/guillefix/frasesdelfary/MainActivity;

    # getter for: Lcom/guillefix/frasesdelfary/MainActivity;->buttonIds:[I
    invoke-static {v4}, Lcom/guillefix/frasesdelfary/MainActivity;->access$000(Lcom/guillefix/frasesdelfary/MainActivity;)[I

    move-result-object v4

    aget v4, v4, v1

    invoke-virtual {v3, v4}, Lcom/guillefix/frasesdelfary/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 290
    .local v2, "soundButton":Landroid/widget/Button;
    invoke-virtual {v2}, Landroid/widget/Button;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 292
    .local v0, "buttonText":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 293
    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 288
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 295
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1

    .line 298
    .end local v0    # "buttonText":Ljava/lang/String;
    .end local v2    # "soundButton":Landroid/widget/Button;
    :cond_1
    return-void
.end method


# virtual methods
.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 1
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 283
    invoke-direct {p0, p1}, Lcom/guillefix/frasesdelfary/MainActivity$3;->buscarFrases(Ljava/lang/String;)V

    .line 284
    const/4 v0, 0x0

    return v0
.end method

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 1
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 277
    invoke-direct {p0, p1}, Lcom/guillefix/frasesdelfary/MainActivity$3;->buscarFrases(Ljava/lang/String;)V

    .line 278
    const/4 v0, 0x0

    return v0
.end method
