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
          name: 'zw',
          prop: 'zw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'gw',
          prop: 'gw',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'bm',
          prop: 'bm',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zz',
          prop: 'zz',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'zj',
          prop: 'zj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmxygzzsqmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmxygzzsqmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmxygzzsqmxid',
          dataType: 'GUID',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pcmxygzzsqid',
          prop: 'pcmxygzzsqid',
          dataType: 'PICKUP',
        },
        {
          name: 'pcmxygzzsqmx',
          prop: 'pcmxygzzsqmxid',
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