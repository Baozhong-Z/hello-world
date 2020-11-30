# Git常用指令 <a href="https://git-scm.com/book/zh/v2">在线文档</a>
<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606737991669&di=7192816a6476f61e69a0e3f7054cc78f&imgtype=0&src=http%3A%2F%2Fimg2018.cnblogs.com%2Fblog%2F1612451%2F201905%2F1612451-20190506155730302-759639837.png" alt="流程图">


## 将一个文件夹变为git库
+ > git init
+ > get clone + \<url\> + [project-name]
## 显示文件状态
> git status  // 完全显示

>get status -s   // 更精简的显示
## 将文件变为已跟踪状态
> git add 路径or文件名
## 将文件由已跟踪变为未跟踪
> git reset HEAD 文件名or目录
## 将暂存区的文件保存到本地仓库
> git commit -m "描述"
+ ### 重新提交
> git commit --amend
## 将文件从工作区删除
> git rm 文件名or目录 (支持表达式 ex: /*.log)
### 把文件从 Git 仓库中删除（亦即从暂存区域移除），但仍然希望保留在当前工作目录中
> git rm --cached 文件名or目录 (支持表达式 ex: /*.log)
## 查看日志记录
> git log
    
+ ### 显示每次提交所引入的差异
    > git log -p -2 (-2 选项来只显示最近的两次提交)

## 查看尚未暂存的文件更新了哪些部分
> git diff
+ ### 查看已暂存的将要添加到下次提交里的内容
     > git diff --staged
## 自动把所有已经跟踪过的文件暂存起来一并提交，从而跳过 git add 步骤
> git commit -a 
## 要在 Git 中对文件改名
> git mv file_from file_to
+ 其实，运行 git mv 就相当于运行了下面三条命令：
    > $ mv README.md README

    > $ git rm README.md

    > $ git add README
## 查看你已经配置的远程仓库服务器
> git remote
+ ### 显示需要读写远程仓库使用的 Git 保存的简写与其对应的 URL
    > git remote -v
## 标签
### 创建标签
+ #### 轻量标签（lightweight）
    > git tag \<tag-name>
+ #### 附注标签（annotated）
    > git tag -a \<tag-name> +<"描述">
### 后期打标签
> $ git log --pretty=oneline
```
15027957951b64cf874c3557a0f3547bd83b3ff6 Merge branch 'experiment'
a6b4c97498bd301d84096da251c98a07c7723e65 beginning write support
0d52aaab4479697da7686c15f77a3d64d9165190 one more thing
6d52a271eda8725415634dd79daabbc4d9b6008e Merge branch 'experiment'
0b7434d86859cc7b8c3d5e1dddfed66ff742fcbc added a commit function
4682c3261057305bdd616e23b64b0857d832627b added a todo file
166ae0c4d3f420721acbb115cc33848dfcc2121a started write support
9fceb02d0ae598e95dc970b74767f19372d61af8 updated rakefile
964f16d36dfccde844893cac5b347e7b3d44abbc commit the todo
8a5cbc430f1a9c3d00faaeffd07798508422908a updated readme
```
现在，假设在 v1.2 时你忘记给项目打标签，也就是在 “updated rakefile” 提交。 你可以在之后补上标签。 要在那个提交上打标签，你需要在命令的末尾指定提交的校验和（或部分校验和）：
> git tag -a v1.2 9fceb02
### 展示标签
+ > git show
### 共享标签
默认情况下，git push 命令并不会传送标签到远程仓库服务器上。 在创建完标签后你必须显式地推送标签到共享服务器上。
> git push \<remote> \<tagname>

如果想要一次性推送很多标签，也可以使用带有 --tags 选项的 git push 命令。 这将会把所有不在远程仓库服务器上的标签全部传送到那里。
> git push \<remote> --tags
### 删除标签
> git tag -d \<tagname>
## 分支
### 创建分支
> git branch \<branch-name>
### 查看分支
> git log --oneline --decorate

+ 运行 git log --oneline --decorate --graph --all ，它会输出你的提交历史、各个分支的指向以及项目的分支分叉情况
> git log --oneline --decorate --graph --all
```
f30ab (HEAD -> master, testing) add feature #32 - ability to add new formats to the central interface
34ac2 Fixed bug #1328 - stack overflow under certain conditions
98ca9 The initial commit of my project
```
正如你所见，当前 master 和 testing 分支均指向校验和以 f30ab 开头的提交对象。
### 分支切换
> git checkout \<branch-name>
#### 通常我们会在创建一个新分支后立即切换过去，这可以用：
> git checkout -b \<branch-name>
### 分支合并
> git merge \<branch-name> (在当前分支合并目标分支branch-name)
### <font color="green">遇到冲突时的分支合并</font>
1. <font color="red">**你可以在合并冲突后的任意时刻使用 git status 命令来查看那些因包含合并冲突而处于未合并（unmerged）状态的文件：**</font>
    > git status
    ```
    On branch master
    You have unmerged paths.
    (fix conflicts and run "git commit")

    Unmerged paths:
    (use "git add <file>..." to mark resolution)

        both modified:      index.html

    no changes added to commit (use "git add" and/or "git commit -a")
    ```
2. <font color="red">**为了解决冲突，你必须选择使用由 ======= 分割的两部分中的一个，或者你也可以自行合并这些内容。**</font>

3. <font color="red">如果你对结果感到满意，并且确定之前有冲突的的文件都已经暂存了，这时你可以输入 **git commit** 来完成合并提交</font>
### 分支删除
> git branch -d \<branch-name>

## 数据恢复 <a href="https://git-scm.com/book/zh/v2/Git-%E5%86%85%E9%83%A8%E5%8E%9F%E7%90%86-%E7%BB%B4%E6%8A%A4%E4%B8%8E%E6%95%B0%E6%8D%AE%E6%81%A2%E5%A4%8D#_data_recovery">参考文档</a>
在你使用 Git 的时候，你可能会意外丢失一次提交。 通常这是因为你强制删除了正在工作的分支，但是最后却发现你还需要这个分支， 亦或者硬重置了一个分支，放弃了你想要的提交。 如果这些事情已经发生，该如何找回你的提交呢？
1. 首先，让我们看看你的仓库现在在什么地方：
    > git log --pretty=oneline
    ```
    ab1afef80fac8e34258ff41fc1b867c702daa24b modified repo a bit
    484a59275031909e19aadb7c92262719cfcdf19a added repo.rb
    1a410efbd13591db07496601ebc7a059dd55cfe9 third commit
    cac0cab538b970a37ea1e769cbbde608743bc96d second commit
    fdf4fc3344e67ab068f836878b6c4951e3b15f3d first commit
    ```
2. 现在，我们将 master 分支硬重置到第三次提交：
    > git reset--hard 1a410efbd13591db07496601ebc7a059dd55cfe9
    ```
    HEAD is now at 1a410ef third commit
    $ git log --pretty=oneline
    1a410efbd13591db07496601ebc7a059dd55cfe9 third commit
    cac0cab538b970a37ea1e769cbbde608743bc96d second commit
    fdf4fc3344e67ab068f836878b6c4951e3b15f3d first commit
    ```

3. 现在顶部的两个提交已经丢失了——没有分支指向这些提交。 你需要找出最后一次提交的 SHA-1 然后增加一个指向它的分支。**最方便**，也是**最常用**的方法，是使用一个名叫 **git reflog** 的工具。 当你正在工作时，Git 会默默地记录每一次你改变 HEAD 时它的值。 每一次你提交或改变分支，引用日志都会被更新。
    > git log -g
4. 看起来下面的那个就是你丢失的提交，你可以通过创建一个新的分支指向这个提交来恢复它。 例如，你可以创建一个名为 recover-branch 的分支指向这个提交
    > git branch recover-branch ab1afef

## 移除对象（历史中的）

Git 有很多很棒的功能，但是其中一个特性会导致问题，git clone 会下载整个项目的历史，包括每一个文件的每一个版本。 如果所有的东西都是源代码那么这很好，因为 Git 被高度优化来有效地存储这种数据。 然而，如果某个人在之前向项目添加了一个大小特别大的文件，即使你将这个文件从项目中移除了，每次克隆还是都要强制的下载这个大文件。 之所以会产生这个问题，是因为这个文件在历史中是存在的，它会永远在那里。
