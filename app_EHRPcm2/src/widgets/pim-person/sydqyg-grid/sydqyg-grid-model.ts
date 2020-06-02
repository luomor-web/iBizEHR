/**
 * SYDQYG 部件模型
 *
 * @export
 * @class SYDQYGModel
 */
export default class SYDQYGModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof SYDQYGGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof SYDQYGGridMode
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
          name: 'sydq',
          prop: 'sydq',
          dataType: 'DATE',
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
          name: 'pimpersonid3',
          prop: 'pimpersonid3',
          dataType: 'PICKUP',
        },
        {
          name: 'dbdwsj',
          prop: 'dbdwsj',
          dataType: 'DATE',
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