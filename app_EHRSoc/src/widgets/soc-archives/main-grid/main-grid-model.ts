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
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'socaccountid',
          prop: 'socaccountid',
          dataType: 'PICKUP',
        },
        {
          name: 'socaccountname',
          prop: 'socaccountname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'socrulename',
          prop: 'socrulename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'state',
          prop: 'state',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'socarchivesname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'socarchivesid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'socarchivesid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ygzt',
          prop: 'ygzt',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'socruleid',
          prop: 'socruleid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'socarchivesid',
          prop: 'socarchivesid',
          dataType: 'GUID',
        },
        {
          name: 'socarchives',
          prop: 'socarchivesid',
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