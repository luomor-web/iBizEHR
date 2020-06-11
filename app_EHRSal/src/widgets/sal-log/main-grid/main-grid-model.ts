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
          name: 'createdate',
          prop: 'createdate',
          dataType: 'DATETIME',
        },
        {
          name: 'val1',
          prop: 'val1',
          dataType: 'TEXT',
        },
        {
          name: 'salsalarydetailid',
          prop: 'salsalarydetailid',
          dataType: 'PICKUP',
        },
        {
          name: 'val2',
          prop: 'val2',
          dataType: 'TEXT',
        },
        {
          name: 'salsalarydetailname',
          prop: 'salsalarydetailname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'createman',
          prop: 'createman',
          dataType: 'TEXT',
        },
        {
          name: 'salsalaryname',
          prop: 'salsalaryname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'sallogname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'sallogid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'sallogid',
          dataType: 'GUID',
        },
        {
          name: 'sallogname',
          prop: 'sallogname',
          dataType: 'TEXT',
        },
        {
          name: 'sallog',
          prop: 'sallogid',
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