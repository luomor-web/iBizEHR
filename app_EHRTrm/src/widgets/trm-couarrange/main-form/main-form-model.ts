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
        prop: 'trmcouarrangeid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmcouarrangename',
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
        name: 'trmtrainagencyname',
        prop: 'trmtrainagencyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'trmtrainaddressname',
        prop: 'trmtrainaddressname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'trmtrainteachername',
        prop: 'trmtrainteachername',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'skkssj',
        prop: 'skkssj',
        dataType: 'DATE',
      },
      {
        name: 'skjssj',
        prop: 'skjssj',
        dataType: 'DATE',
      },
      {
        name: 'pj',
        prop: 'pj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmtrainaddressid',
        prop: 'trmtrainaddressid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainagencyid',
        prop: 'trmtrainagencyid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtraincourseid',
        prop: 'trmtraincourseid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmtrainteacherid',
        prop: 'trmtrainteacherid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmcouarrangeid',
        prop: 'trmcouarrangeid',
        dataType: 'GUID',
      },
      {
        name: 'trmtrainplantermid',
        prop: 'trmtrainplantermid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmcouarrange',
        prop: 'trmcouarrangeid',
        dataType: 'FONTKEY',
      },
    ]
  }

}