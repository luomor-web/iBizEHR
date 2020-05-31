/**
 * YGZZ 部件模型
 *
 * @export
 * @class YGZZModel
 */
export default class YGZZModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof YGZZGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof YGZZGridMode
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
          name: 'cjsj',
          prop: 'cjsj',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'pimexitandentryname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimexitandentryid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimexitandentryid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'lx',
          prop: 'lx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'rank',
          prop: 'rank',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'qwfhgj',
          prop: 'qwfhgj',
          dataType: 'TEXT',
        },
        {
          name: 'workflowstate',
          prop: 'workflowstate',
          dataType: 'SSCODELIST',
        },
        {
          name: 'rjsj',
          prop: 'rjsj',
          dataType: 'DATE',
        },
        {
          name: 'sy',
          prop: 'sy',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfdatatype',
          prop: 'workflowstate',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimexitandentry',
          prop: 'pimexitandentryid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_lx_eq',
        prop: 'n_lx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_workflowstate_eq',
        prop: 'n_workflowstate_eq',
        dataType: 'SSCODELIST',
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