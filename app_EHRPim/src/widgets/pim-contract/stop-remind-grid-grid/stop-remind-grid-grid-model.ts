/**
 * StopRemindGrid 部件模型
 *
 * @export
 * @class StopRemindGridModel
 */
export default class StopRemindGridModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof StopRemindGridGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof StopRemindGridGridMode
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
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimlabourcampanyid',
          prop: 'pimlabourcampanyid',
          dataType: 'PICKUP',
        },
        {
          name: 'qsrq',
          prop: 'qsrq',
          dataType: 'DATE',
        },
        {
          name: 'htlx',
          prop: 'htlx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimcontractid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimcontractid',
          dataType: 'GUID',
        },
        {
          name: 'htbh',
          prop: 'htbh',
          dataType: 'TEXT',
        },
        {
          name: 'signingunit',
          prop: 'signingunit',
          dataType: 'TEXT',
        },
        {
          name: 'htsyts',
          prop: 'htsyts',
          dataType: 'INT',
        },
        {
          name: 'htzt',
          prop: 'htzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'cz',
          prop: 'cz',
          dataType: 'TEXT',
        },
        {
          name: 'jsrq',
          prop: 'jsrq',
          dataType: 'DATE',
        },
        {
          name: 'contracttype',
          prop: 'contracttype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ygzt',
          prop: 'ygzt',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormsignorgname',
          prop: 'ormsignorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'dbdwsj',
          prop: 'dbdwsj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pimlabourcampanyname',
          prop: 'pimlabourcampanyname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormsignorgid',
          prop: 'ormsignorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'contracttype_text',
          prop: 'contracttype',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'contractsignorgid',
          prop: 'contractsignorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimcontract',
          prop: 'pimcontractid',
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
        name: 'n_ygzt_eq',
        prop: 'n_ygzt_eq',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_htbh_like',
        prop: 'n_htbh_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_htlx_eq',
        prop: 'n_htlx_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_htzt_eq',
        prop: 'n_htzt_eq',
        dataType: 'SSCODELIST',
      },
      {
        name: 'n_qsrq_gtandeq',
        prop: 'n_qsrq_gtandeq',
        dataType: 'DATE',
      },
      {
        name: 'n_jsrq_ltandeq',
        prop: 'n_jsrq_ltandeq',
        dataType: 'DATE',
      },
      {
        name: 'n_contracttype_eq',
        prop: 'n_contracttype_eq',
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