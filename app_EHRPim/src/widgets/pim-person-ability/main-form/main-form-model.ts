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
        prop: 'pimpersonabilityid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pimpersonabilityname',
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
        name: 'pimpersonabilityname',
        prop: 'pimpersonabilityname',
        dataType: 'TEXT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimpersonname',
        prop: 'pimpersonname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'year',
        prop: 'year',
        dataType: 'INT',
      },
      {
        name: 'month',
        prop: 'month',
        dataType: 'INT',
      },
      {
        name: 'recorddate',
        prop: 'recorddate',
        dataType: 'DATE',
      },
      {
        name: 'eduscore',
        prop: 'eduscore',
        dataType: 'FLOAT',
      },
      {
        name: 'performscore',
        prop: 'performscore',
        dataType: 'FLOAT',
      },
      {
        name: 'pracscore',
        prop: 'pracscore',
        dataType: 'FLOAT',
      },
      {
        name: 'techscore',
        prop: 'techscore',
        dataType: 'TEXT',
      },
      {
        name: 'trainresultscore',
        prop: 'trainresultscore',
        dataType: 'FLOAT',
      },
      {
        name: 'pimpersonabilityid',
        prop: 'pimpersonabilityid',
        dataType: 'GUID',
      },
      {
        name: 'pimpersonability',
        prop: 'pimpersonabilityid',
        dataType: 'FONTKEY',
      },
    ]
  }

}