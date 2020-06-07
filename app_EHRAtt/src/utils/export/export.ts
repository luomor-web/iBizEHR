/**
 * exportExcel 对象
 * 调用 getInstance() 获取实例
 *
 * @class exportExcel
 */
export class exportExcel {

    /**
     * 获取 exportExcel 单例对象
     *
     * @static
     * @returns {exportExcel}
     * @memberof exportExcel
     */
    public static getInstance(): exportExcel {
        if (!exportExcel.exportExcel) {
          exportExcel.exportExcel = new exportExcel();
        }
        return this.exportExcel;
    }

    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {exportExcel}
     * @memberof exportExcel
     */
    private static exportExcel: exportExcel;

    /**
     * 获取导出excel核心包
     * 
     * @memberof exportExcel
     */
    public async exportExcel(){
        let excel:any =  await import("@/utils/export2Excel/Export2Excel");
        return excel;
    }

}