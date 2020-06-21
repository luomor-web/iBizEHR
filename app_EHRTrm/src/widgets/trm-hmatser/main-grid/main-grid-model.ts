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
          name: 'trmtrainagencyid',
          prop: 'trmtrainagencyid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'xb',
          prop: 'xb',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zjhm',
          prop: 'zjhm',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'nj',
          prop: 'nj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'trmhmatsername',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmhmatserid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'trmhmatserid',
          dataType: 'GUID',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmhmatser',
          prop: 'trmhmatserid',
        },
      {
        name: 'n_trmhmatsername_like',
        prop: 'n_trmhmatsername_like',
        dataType: 'TEXT',
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