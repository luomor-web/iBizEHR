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
          name: 'socareaid',
          prop: 'socareaid',
          dataType: 'PICKUP',
        },
        {
          name: 'memo',
          prop: 'memo',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'nyear',
          prop: 'nyear',
          dataType: 'NSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'socrulename',
          prop: 'socrulename',
          dataType: 'TEXT',
        },
        {
          name: 'state',
          prop: 'state',
          dataType: 'SSCODELIST',
        },
        {
          name: 'socareaname',
          prop: 'socareaname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'socrulename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'socruleid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'socruleid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'socrule',
          prop: 'socruleid',
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