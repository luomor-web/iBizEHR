/**
 * KTXYG 部件模型
 *
 * @export
 * @class KTXYGModel
 */
export default class KTXYGModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof KTXYGGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof KTXYGGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'retiplace',
          prop: 'retiplace',
          dataType: 'TEXT',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'gw',
          prop: 'gw',
          dataType: 'SSCODELIST',
        },
        {
          name: 'txnx_color',
          prop: 'txnx_color',
          dataType: 'TEXT',
        },
        {
          name: 'pimmajorsetypeid',
          prop: 'pimmajorsetypeid',
          dataType: 'PICKUP',
        },
        {
          name: 'pcmrcxlid',
          prop: 'pcmrcxlid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimpersonid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimpersonid',
          dataType: 'GUID',
        },
        {
          name: 'pimcityid',
          prop: 'pimcityid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'zw',
          prop: 'zw',
          dataType: 'SSCODELIST',
        },
        {
          name: 'sjtxrq',
          prop: 'sjtxrq',
          dataType: 'DATE',
        },
        {
          name: 'pcmjxsygzzjlmxid',
          prop: 'pcmjxsygzzjlmxid',
          dataType: 'PICKUP',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pimpersonid2',
          prop: 'pimpersonid2',
          dataType: 'PICKUP',
        },
        {
          name: 'postaladdress',
          prop: 'postaladdress',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid3',
          prop: 'pimpersonid3',
          dataType: 'PICKUP',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
          dataType: 'TEXT',
        },
        {
          name: 'txnx',
          prop: 'txnx',
          dataType: 'TEXT',
        },
        {
          name: 'nj',
          prop: 'nj',
          dataType: 'INT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'TEXT',
        },
        {
          name: 'pimperson',
          prop: 'pimpersonid',
        },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_like',
        prop: 'n_ormorgsectorname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ygzt_eq',
        prop: 'n_ygzt_eq',
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