/**
 * NDLHMBKHMX_JZSZPS 部件模型
 *
 * @export
 * @class NDLHMBKHMX_JZSZPSModel
 */
export default class NDLHMBKHMX_JZSZPSModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof NDLHMBKHMX_JZSZPSGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof NDLHMBKHMX_JZSZPSGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'fz',
          prop: 'fz',
          dataType: 'FLOAT',
        },
        {
          name: 'wcqk',
          prop: 'wcqk',
          dataType: 'TEXT',
        },
        {
          name: 'parldndlhmbmxname',
          prop: 'parldndlhmbmxname',
          dataType: 'TEXT',
        },
        {
          name: 'xgrz',
          prop: 'xgrz',
          dataType: 'TEXT',
        },
        {
          name: 'zpfs',
          prop: 'zpfs',
          dataType: 'FLOAT',
        },
        {
          name: 'spzt',
          prop: 'spzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'mblx',
          prop: 'mblx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'parldndlhmbmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'parldndlhmbmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'parldndlhmbmxid',
          dataType: 'GUID',
        },
        {
          name: 'jzszpsfs',
          prop: 'jzszpsfs',
          dataType: 'FLOAT',
        },
        {
          name: 'zt',
          prop: 'zt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'mblhyq',
          prop: 'mblhyq',
          dataType: 'TEXT',
        },
        {
          name: 'fgldpf',
          prop: 'fgldpf',
          dataType: 'FLOAT',
        },
        {
          name: 'parldndlhmbname',
          prop: 'parldndlhmbname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'khbf',
          prop: 'khbf',
          dataType: 'TEXT',
        },
        {
          name: 'parldndlhmbid',
          prop: 'parldndlhmbid',
          dataType: 'PICKUP',
        },
        {
          name: 'parldndlhmbmx',
          prop: 'parldndlhmbmxid',
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