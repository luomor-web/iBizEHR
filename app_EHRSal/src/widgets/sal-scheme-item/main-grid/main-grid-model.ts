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
          name: 'memo',
          prop: 'memo',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'salschemename',
          prop: 'salschemename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'salitemid',
          prop: 'salitemid',
          dataType: 'PICKUP',
        },
        {
          name: 'salitemname',
          prop: 'salitemname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'salruleid',
          prop: 'salruleid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'salitemname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'salschemeitemid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'salschemeitemid',
          dataType: 'GUID',
        },
        {
          name: 'sitemadd',
          prop: 'sitemadd',
          dataType: 'SSCODELIST',
        },
        {
          name: 'xh2',
          prop: 'xh2',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'salrulename',
          prop: 'salrulename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'sitemtype',
          prop: 'sitemtype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'gs',
          prop: 'gs',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'salschemeid',
          prop: 'salschemeid',
          dataType: 'PICKUP',
        },
        {
          name: 'salschemeitem',
          prop: 'salschemeitemid',
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