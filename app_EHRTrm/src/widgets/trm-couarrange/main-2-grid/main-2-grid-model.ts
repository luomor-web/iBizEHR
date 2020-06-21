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
          name: 'trmtraincourseid',
          prop: 'trmtraincourseid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainplantermname',
          prop: 'trmtrainplantermname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmcoursesystemid',
          prop: 'trmcoursesystemid',
          dataType: 'PICKUP',
        },
        {
          name: 'skjssj',
          prop: 'skjssj',
          dataType: 'DATE',
        },
        {
          name: 'trmtrainteacherid',
          prop: 'trmtrainteacherid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainactapplyid',
          prop: 'trmtrainactapplyid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainaddressname',
          prop: 'trmtrainaddressname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmagencyrecordid',
          prop: 'trmagencyrecordid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainaddressid',
          prop: 'trmtrainaddressid',
          dataType: 'PICKUP',
        },
        {
          name: 'skkssj',
          prop: 'skkssj',
          dataType: 'DATE',
        },
        {
          name: 'trmtrainplantermid',
          prop: 'trmtrainplantermid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'trmcouarrangename',
          dataType: 'TEXT',
        },
        {
          name: 'trmtraincoursename',
          prop: 'trmtraincoursename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmcouarrangeid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmcouarrangeid',
          dataType: 'GUID',
        },
        {
          name: 'trmtrainfaciesid',
          prop: 'trmtrainfaciesid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrianpersonid',
          prop: 'trmtrianpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainagencyid',
          prop: 'trmtrainagencyid',
          dataType: 'PICKUP',
        },
        {
          name: 'pj',
          prop: 'pj',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'trmcouarrange',
          prop: 'trmcouarrangeid',
        },
      {
        name: 'n_trmtrainplantermname_like',
        prop: 'n_trmtrainplantermname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtraincoursename_like',
        prop: 'n_trmtraincoursename_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_trmtrainfaciesname_like',
        prop: 'n_trmtrainfaciesname_like',
        dataType: 'PICKUPTEXT',
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