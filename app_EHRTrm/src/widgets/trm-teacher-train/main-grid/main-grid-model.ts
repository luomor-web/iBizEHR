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
          name: 'trmtrainteacherid',
          prop: 'trmtrainteacherid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainaddressname',
          prop: 'trmtrainaddressname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'trmtrainaddressid',
          prop: 'trmtrainaddressid',
          dataType: 'PICKUP',
        },
        {
          name: 'trmtrainplantermid',
          prop: 'trmtrainplantermid',
          dataType: 'PICKUP',
        },
        {
          name: 'srfmajortext',
          prop: 'trmteachertrainname',
          dataType: 'TEXT',
        },
        {
          name: 'trmtraincoursename',
          prop: 'trmtraincoursename',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'srfkey',
          prop: 'trmteachertrainid',
          dataType: 'GUID',
        },
        {
          name: 'srfdataaccaction',
          prop: 'trmteachertrainid',
          dataType: 'GUID',
        },
        {
          name: 'pxsc',
          prop: 'pxsc',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'jf',
          prop: 'jf',
          dataType: 'FLOAT',
        },
        {
          name: 'pxkssj',
          prop: 'pxkssj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pxjssj',
          prop: 'pxjssj',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pj',
          prop: 'pj',
          dataType: 'LONGTEXT_1000',
        },
        {
          name: 'trmteachertrain',
          prop: 'trmteachertrainid',
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
        name: 'n_trmtrainaddressname_like',
        prop: 'n_trmtrainaddressname_like',
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