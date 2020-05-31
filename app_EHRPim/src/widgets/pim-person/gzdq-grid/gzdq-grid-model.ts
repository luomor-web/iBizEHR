/**
 * GZDQ 部件模型
 *
 * @export
 * @class GZDQModel
 */
export default class GZDQModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof GZDQGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof GZDQGridMode
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
          name: 'gzkssj',
          prop: 'gzkssj',
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
          name: 'gzzz',
          prop: 'gzzz',
          dataType: 'TEXT',
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
          name: 'pcmjxsygzzjlmxid',
          prop: 'pcmjxsygzzjlmxid',
          dataType: 'PICKUP',
        },
        {
          name: 'gzzt',
          prop: 'gzzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid2',
          prop: 'pimpersonid2',
          dataType: 'PICKUP',
        },
        {
          name: 'ygzt',
          prop: 'ygzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimpersonid3',
          prop: 'pimpersonid3',
          dataType: 'PICKUP',
        },
        {
          name: 'gzbm',
          prop: 'gzbm',
          dataType: 'TEXT',
        },
        {
          name: 'gzjssj',
          prop: 'gzjssj',
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