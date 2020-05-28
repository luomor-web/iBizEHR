/**
 * Main_2 部件模型
 *
 * @export
 * @class Main_2Model
 */
export default class Main_2Model {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_2GridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgdzid',
          prop: 'ormorgdzid',
          dataType: 'TEXT',
        },
        {
          name: 'updateman',
          prop: 'updateman',
          dataType: 'TEXT',
        },
        {
          name: 'attendancerange',
          prop: 'attendancerange',
          dataType: 'INT',
        },
        {
          name: 'updatedate',
          prop: 'updatedate',
          dataType: 'DATE',
        },
        {
          name: 'srfmajortext',
          prop: 'ormbmkqdzname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'ormbmkqdzid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'ormbmkqdzid',
          dataType: 'GUID',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormbmkqdzname',
          prop: 'ormbmkqdzname',
          dataType: 'TEXT',
        },
        {
          name: 'ormbmkqdz',
          prop: 'ormbmkqdzid',
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