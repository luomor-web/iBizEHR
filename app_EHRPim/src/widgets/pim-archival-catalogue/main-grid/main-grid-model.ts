/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof MainGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'pimarchivesid',
          prop: 'pimarchivesid',
          dataType: 'PICKUP',
        },
        {
          name: 'archivalcataloguename',
          prop: 'archivalcataloguename',
          dataType: 'TEXT',
        },
        {
          name: 'serialnumber',
          prop: 'serialnumber',
          dataType: 'INT',
        },
        {
          name: 'srfmajortext',
          prop: 'archivalcataloguename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'archivalcatalogueid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'archivalcatalogueid',
          dataType: 'GUID',
        },
        {
          name: 'pimarchivalcatalogue',
          prop: 'archivalcatalogueid',
        },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}