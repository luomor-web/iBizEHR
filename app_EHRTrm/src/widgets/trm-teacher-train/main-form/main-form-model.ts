/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'trmteachertrainid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmteachertrainname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'trmtrainteacherid',
        prop: 'trmtrainteacherid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainteachername',
        prop: 'trmtrainteachername',
        dataType: 'PICKUPTEXT',
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
        name: 'trmtrainplantermname',
        prop: 'trmtrainplantermname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'trmtraincoursename',
        prop: 'trmtraincoursename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pxsc',
        prop: 'pxsc',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'trmtrainaddressname',
        prop: 'trmtrainaddressname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jf',
        prop: 'jf',
        dataType: 'FLOAT',
      },
      {
        name: 'pj',
        prop: 'pj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtraincourseid',
        prop: 'trmtraincourseid',
        dataType: 'PICKUP',
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
        name: 'trmteachertrainid',
        prop: 'trmteachertrainid',
        dataType: 'GUID',
      },
      {
        name: 'trmteachertrain',
        prop: 'trmteachertrainid',
        dataType: 'FONTKEY',
      },
    ]
  }

}