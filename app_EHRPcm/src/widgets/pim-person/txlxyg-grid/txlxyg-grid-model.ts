/**
 * TXLXYG 部件模型
 *
 * @export
 * @class TXLXYGModel
 */
export default class TXLXYGModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof TXLXYGGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof TXLXYGGridMode
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
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'spdylje',
          prop: 'spdylje',
          dataType: 'FLOAT',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'pimmajorsetypeid',
          prop: 'pimmajorsetypeid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimpersonid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimpersonid',
          dataType: 'GUID',
        },
        {
          name: 'zw',
          prop: 'zw',
          dataType: 'SSCODELIST',
        },
        {
          name: 'rank',
          prop: 'rank',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid2',
          prop: 'pimpersonid2',
          dataType: 'PICKUP',
        },
        {
          name: 'pimpersonid3',
          prop: 'pimpersonid3',
          dataType: 'PICKUP',
        },
        {
          name: 'xb',
          prop: 'xb',
          dataType: 'SSCODELIST',
        },
        {
          name: 'retiplace',
          prop: 'retiplace',
          dataType: 'TEXT',
        },
        {
          name: 'jtlxrdh',
          prop: 'jtlxrdh',
          dataType: 'TEXT',
        },
        {
          name: 'gw',
          prop: 'gw',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pcmrcxlid',
          prop: 'pcmrcxlid',
          dataType: 'PICKUP',
        },
        {
          name: 'jtlxr',
          prop: 'jtlxr',
          dataType: 'TEXT',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimcityid',
          prop: 'pimcityid',
          dataType: 'PICKUP',
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
          name: 'postaladdress',
          prop: 'postaladdress',
          dataType: 'TEXT',
        },
        {
          name: 'lxdh',
          prop: 'lxdh',
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
          name: 'txdq',
          prop: 'txdq',
          dataType: 'DATE',
        },
        {
          name: 'pimperson',
          prop: 'pimpersonid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'TEXT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
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
        name: 'n_sjtxrq_gtandeq',
        prop: 'n_sjtxrq_gtandeq',
        dataType: 'DATE',
      },
      {
        name: 'n_sjtxrq_ltandeq',
        prop: 'n_sjtxrq_ltandeq',
        dataType: 'DATE',
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