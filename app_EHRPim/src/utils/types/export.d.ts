import Vue, { VNode, CreateElement } from "vue";

export declare interface exportExcel {
  exportExcel(): Promise<any>;

}

declare module "vue/types/vue" {
  interface Vue {
      /**
       * exportExcel 对象
       *
       * @type {exportExcel}
       * @memberof Vue
       */
      $export: exportExcel;
  }
}