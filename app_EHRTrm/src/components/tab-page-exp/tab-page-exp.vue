<template>
  <div class="ibiz-page-tag">
    <div class="tag-tabs left">
      <el-tabs
        type="card"
        @tab-click="changePage"
        v-model="editableTabsValue"
        closable 
        @tab-remove="onClose"
      >
        <el-tab-pane
          v-for="(meta, index) of $store.state.pageMetas"
          :name="index+''"
          :key="index+''"
         
        >
        <span slot="label"><span class="ivu-tag-dot-inner"></span>{{ getCaption(meta.caption, meta.info) }}</span>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div v-show="$store.state.pageMetas.length > 0" class="right">
      <el-dropdown @command="handlerClose">
        <el-button size="mini" type="primary">
          更多<i class="el-icon-arrow-down el-icon--right"></i>
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item :command="item" v-for="(item,index) in actions" :key="index">{{ $t(item.text) }}</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang="ts">
import { Vue, Component, Provide, Prop, Watch } from "vue-property-decorator";
import { Environment } from "../../environments/environment";

@Component({})
export default class TabPageExp extends Vue {

  @Provide()
  public styleLeft: number = 0;

  @Provide()
  public actions: any[] = [
    { text: "app.tabpage.closeall", value: "closeAll" },
    { text: "app.tabpage.closeother", value: "closeOther" }
  ];

  /**
   * 关闭tab页方法
   */
  public handlerClose(item: any){
    this.doTagAction(item.value);
  }

  public editableTabsValue: any = ""; //tabs页绑定值

  @Watch("$route")
  public onRouteChange(newVal: any) {
    this.moveToView(newVal);
    this.$emit("change", newVal);
  }

  public created() {
    Vue.prototype.$tabPageExp = this;
  }

  public getCaption(caption: any, info: any): any {
    return info && !Object.is(info, "")
      ? `${this.$t(caption)} - ${info}`
      : this.$t(caption);
  }

  /**
   * 向左移动
   *
   * @memberof TabPageExp
   */
  public leftMove() {
    const scrollBody: any = this.$refs.scrollBody;
    const scrollChild: any = this.$refs.scrollChild;
    if (
      scrollBody &&
      scrollChild &&
      scrollChild.offsetWidth > scrollBody.offsetWidth
    ) {
      if (
        scrollChild.offsetWidth - scrollBody.offsetWidth + this.styleLeft >
        100
      ) {
        this.styleLeft -= 100;
      } else {
        this.styleLeft = scrollBody.offsetWidth - scrollChild.offsetWidth;
      }
    }
  }

  /**
   * 向右移动
   *
   * @memberof TabPageExp
   */
  public rightMove() {
    if (this.styleLeft < 0) {
      if (this.styleLeft + 100 > 0) {
        this.styleLeft = 0;
      } else {
        this.styleLeft += 100;
      }
    }
  }

  /**
   * 是否选中
   *
   * @param {(string | number)} index
   * @returns
   * @memberof TabPageExp
   */
  public isActive(index: string | number) {
    const page = this.$store.state.pageTagList[index];
    if (Object.is(page.fullPath, this.$route.fullPath)) {
      return true;
    }
    return false;
  }

  /**
   * 关闭
   *
   * @param {*} event
   * @param {*} name
   * @memberof TabPageExp
   */
  public onClose(name: any) {
    const page = this.$store.getters.getPage(name);
    if (!page) {
      this.$store.commit("deletePage", name);
      this.gotoPage();
    }
    const appview = this.$store.getters["viewaction/getAppView"](page.viewtag);
    if (appview && appview.viewdatachange) {
      const title: any = this.$t("app.tabpage.sureclosetip.title");
      const content: any = this.$t("app.tabpage.sureclosetip.content");
      this.$Modal.confirm({
        title: title,
        content: content,
        onOk: () => {
          this.$store.commit("deletePage", name);
          this.gotoPage();
        },
        onCancel: () => {}
      });
    } else {
      this.$store.commit("deletePage", name);
      this.gotoPage();
    }
  }

  /**
   * 是否显示关闭
   *
   * @returns
   * @memberof TabPageExp
   */
  public isClose() {
    const pageTagList = this.$store.state.pageTagList;
    if (pageTagList.length > 1) {
      return true;
    }
    return false;
  }

  /**
   * 切换分页
   *
   * @param {*} index
   * @memberof TabPageExp
   */
  public changePage(tab: any, event: any) {
    this.editableTabsValue = tab.index;
    this.$store.commit("setCurPage", tab.index);
    this.gotoPage();
  }

  /**
   * 跳转页面
   *
   * @returns
   * @memberof TabPageExp
   */
  public gotoPage() {
    const length = this.$store.state.historyPathList.length;
    if (length > 0) {
      const path = this.$store.state.historyPathList[length - 1];
      if (Object.is(path, this.$route.fullPath)) {
        return;
      }
      const index = this.$store.state.pageTagList.findIndex((page: any) =>
        Object.is(page.fullPath, path)
      );
      if (index >= 0) {
        const page = this.$store.state.pageTagList[index];
        this.$router.push({
          path: page.path,
          params: page.params,
          query: page.query
        });
      }
    } else {
      let path: string | null = window.sessionStorage.getItem(
        Environment.AppName
      );
      if (path) {
        this.$router.push({ path: path });
      } else {
        this.$router.push("/");
      }
    }
  }

  /**
   * 设置当前页标题
   *
   * @param {*} caption
   * @memberof TabPageExp
   */
  public setCurPageCaption(caption: string, title: any, info: string) {
    if (this.$route.meta && !Object.is(this.$t(this.$route.meta.caption), caption)) {
      return;
    }
    this.$store.commit("setCurPageCaption", {
      route: this.$route,
      caption: title,
      info: info
    });
    setTimeout(() => {
      this.moveToView(this.$route);
    }, 1);
  }

  /**
   * 移动至指定页面标签
   *
   * @param {*} to
   * @memberof TabPageExp
   */
  /**
   * 移动至指定页面标签
   *
   * @param {*} to
   * @memberof TabPageExp
   */
  public moveToView(to: any) {
    let that: any = this;
    const pages: any[] = this.$store.state.pageTagList;
    let leftWidth: number = 0;
    this.$nextTick(() => {
      let _index: any = "";
      pages.forEach((page, index) => {
        if (Object.is(page.path, to.path)) {
          _index = index + "";
        }
      });
      if (_index !== "") {
        that.editableTabsValue = _index + "";
      }
    });
  }

  /**
   * 设置左侧边距
   *
   * @param {{ offsetWidth: number; }} tag
   * @param {number} leftWidth
   * @memberof TabPageExp
   */
  public setLeft(tag: { offsetWidth: number }, leftWidth: number) {
    if (tag) {
      const scrollBody: any = this.$refs.scrollBody;
      if (leftWidth < -this.styleLeft) {
        this.styleLeft = -leftWidth;
      } else if (
        leftWidth + tag.offsetWidth >
        scrollBody.offsetWidth - this.styleLeft
      ) {
        this.styleLeft -=
          leftWidth +
          tag.offsetWidth -
          (scrollBody.offsetWidth - this.styleLeft);
      }
    }
  }

  /**
   * 执行行为操作
   *
   * @param {string} name
   * @memberof TabPageExp
   */
  public doTagAction(name: string) {
    if (Object.is(name, "closeAll")) {
      this.$store.commit("removeAllPage");
      this.gotoPage();
    } else if (Object.is(name, "closeOther")) {
      this.$store.commit("removeOtherPage");
      this.moveToView(this.$route);
    }
  }
}
</script>

<style lang="less">
@import "./tab-page-exp.less";
</style>
