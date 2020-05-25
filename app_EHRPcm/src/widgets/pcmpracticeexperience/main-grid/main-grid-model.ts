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
          name: 'endtime',
          prop: 'endtime',
          dataType: 'DATE',
        },
        {
          name: 'sxpj',
          prop: 'sxpj',
          dataType: 'TEXT',
        },
        {
          name: 'starttime',
          prop: 'starttime',
          dataType: 'DATE',
        },
        {
          name: 'practicecompanyname',
          prop: 'practicecompanyname',
          dataType: 'TEXT',
        },
        {
          name: 'sxgw',
          prop: 'sxgw',
          dataType: 'TEXT',
        },
        {
          name: 'pcmprofileid',
          prop: 'pcmprofileid',
          dataType: 'PICKUP',
        },
        {
          name: 'practicecontent',
          prop: 'practicecontent',
          dataType: 'TEXT',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmpracticeexperiencename',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmpracticeexperienceid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmpracticeexperienceid',
          dataType: 'GUID',
        },
        {
          name: 'pcmpracticeexperience',
          prop: 'pcmpracticeexperienceid',
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