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
          name: 'jlspzt',
          prop: 'jlspzt',
          dataType: 'TEXT',
        },
        {
          name: 'fj',
          prop: 'fj',
          dataType: 'TEXT',
        },
        {
          name: 'hqsj',
          prop: 'hqsj',
          dataType: 'DATE',
        },
        {
          name: 'pimresearchfindingsname',
          prop: 'pimresearchfindingsname',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'pimresearchfindingsname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimresearchfindingsid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimresearchfindingsid',
          dataType: 'GUID',
        },
        {
          name: 'jlss',
          prop: 'jlss',
          dataType: 'TEXT',
        },
        {
          name: 'pimresearchfindings',
          prop: 'pimresearchfindingsid',
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