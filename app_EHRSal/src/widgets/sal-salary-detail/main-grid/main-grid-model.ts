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
          name: 'salsalaryid',
          prop: 'salsalaryid',
          dataType: 'PICKUP',
        },
        {
          name: 'salschemeitemname',
          prop: 'salschemeitemname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'xc',
          prop: 'xc',
          dataType: 'FLOAT',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'ywms',
          prop: 'ywms',
          dataType: 'TEXT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATETIME',
        },
        {
          name: 'srfmajortext',
          prop: 'salsalarydetailname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'salsalarydetailid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'salsalarydetailid',
          dataType: 'GUID',
        },
        {
          name: 'salschemeitemid',
          prop: 'salschemeitemid',
          dataType: 'PICKUP',
        },
        {
          name: 'salsalarydetail',
          prop: 'salsalarydetailid',
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