/**
 * Main_Language 部件模型
 *
 * @export
 * @class Main_LanguageModel
 */
export default class Main_LanguageModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof Main_LanguageGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof Main_LanguageGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'jlczz',
          prop: 'jlczz',
          dataType: 'TEXT',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'wyyz_text',
          prop: 'wyyz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'wydjhqsj',
          prop: 'wydjhqsj',
          dataType: 'DATE',
        },
        {
          name: 'wyyz',
          prop: 'wyyz',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfmajortext',
          prop: 'pimlanguageabilityname',
          dataType: 'TEXT',
        },
        {
          name: 'srfkey',
          prop: 'pimlanguageabilityid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimlanguageabilityid',
          dataType: 'GUID',
        },
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
          name: 'wydj_text',
          prop: 'wydj',
          dataType: 'SSCODELIST',
        },
        {
          name: 'wydj',
          prop: 'wydj',
          dataType: 'SSCODELIST',
        },
        {
          name: 'jlss',
          prop: 'jlss',
          dataType: 'SSCODELIST',
        },
        {
          name: 'pimlanguageability',
          prop: 'pimlanguageabilityid',
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